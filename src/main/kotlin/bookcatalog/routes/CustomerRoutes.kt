package bookcatalog.routes

import bookcatalog.dao.BookDAO
import bookcatalog.dao.CustomerDAO
import bookcatalog.dtos.EditCustomerDTO
import bookcatalog.mappers.toDTO
import bookcatalog.resources.Customers
import bookcatalog.services.CustomerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject
import util.sorted
import java.util.UUID

fun Route.customerRoutes() {
    val service by inject<CustomerService>()

    get<Customers> { params ->
        call.respond(service.list()
            .map(CustomerDAO::toDTO)
            .sorted(params.order) { it.name })
    }

    get<Customers.Id> {
        service.findById(it.id)?.let { a -> call.respond(a.toDTO()) } ?: call.respond(HttpStatusCode.NotFound)
    }

    post<Customers> {
        call.respond(service.create(call.receive<EditCustomerDTO>()))
    }

    put<Customers.Id> { params ->
        service.update(params.id, call.receive<EditCustomerDTO>()) ?: call.respond(HttpStatusCode.NotFound)
        call.respond(HttpStatusCode.OK)
    }

    delete<Customers.Id> { params ->
        call.respond(if (service.delete(params.id)) HttpStatusCode.OK else HttpStatusCode.NotFound)
    }

    get<Customers.Search> { params ->
        // https://youtrack.jetbrains.com/issue/KTOR-5898/serializerForTypeInfo-throws-an-error-about-polymorphic-serialization-instead-of-a-serializer-not-found-one
        call.respond(params.name?.let(service::findByName)?.map(CustomerDAO::toDTO)
            ?: service.list().map(CustomerDAO::toDTO))
    }

    get<Customers.Id.Favourites> { params ->
        call.respond(transaction {
            service.findById(params.parent.id)?.favouriteBooks?.map(BookDAO::toDTO)
        } ?: emptyList())
    }

    post<Customers.Id.Favourites> { params ->
        call.respond(if (service.addFavouriteBook(params.parent.id, call.receive<UUID>())) HttpStatusCode.OK else HttpStatusCode.NotFound)
    }
}