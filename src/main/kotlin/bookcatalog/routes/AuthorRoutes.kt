package bookcatalog.routes

import bookcatalog.mappers.toDTO
import bookcatalog.resources.Authors
import bookcatalog.services.AuthorService
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.authorRoutes() {
    val service by inject<AuthorService>()

    get<Authors> {
        call.respond(service.list().map { it.toDTO() })
    }
}