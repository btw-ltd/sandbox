package bookcatalog.routes

import bookcatalog.dao.AuthorDAO
import bookcatalog.dtos.EditAuthorDTO
import bookcatalog.mappers.toDTO
import bookcatalog.resources.Authors
import bookcatalog.services.AuthorService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route
import org.koin.ktor.ext.inject
import util.sorted

fun Route.authorRoutes() {
    val service by inject<AuthorService>()

    get<Authors.List> { params ->
        call.respond(service.list()
            .map(AuthorDAO::toDTO)
            .sorted(params.order) { it.name })
    }

    get<Authors.Id> {
        service.findById(it.id)?.let { a -> call.respond(a.toDTO()) } ?: call.respond(HttpStatusCode.NotFound)
    }

    post<Authors> {
        call.respond(service.create(call.receive<EditAuthorDTO>()))
    }

    put<Authors.Id> { params ->
        service.update(params.id, call.receive<EditAuthorDTO>()) ?: call.respond(HttpStatusCode.NotFound)
        call.respond(HttpStatusCode.OK)
    }

    delete<Authors.Id> { params ->
        call.respond(if (service.delete(params.id)) HttpStatusCode.OK else HttpStatusCode.NotFound)
    }

    get<Authors.Search> { params ->
        // https://youtrack.jetbrains.com/issue/KTOR-5898/serializerForTypeInfo-throws-an-error-about-polymorphic-serialization-instead-of-a-serializer-not-found-one
        call.respond(params.name?.let(service::findByName)?.map(AuthorDAO::toDTO)
            ?: service.list().map(AuthorDAO::toDTO))
    }
}