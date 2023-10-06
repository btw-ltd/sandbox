package bookcatalog.routes

import bookcatalog.dao.BookDAO
import bookcatalog.mappers.toDTO
import bookcatalog.resources.Books
import bookcatalog.services.BookService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.bookRoutes() {
    val service by inject<BookService>()

    get<Books> {
        call.respond(service.list())
    }

    get<Books.Id> {
        service.findById(it.id)?.let { a -> call.respond(a.toDTO()) } ?: call.respond(HttpStatusCode.NotFound)
    }

    get<Books.Id.Name> {
        service.getTitle(it.parent.id)?.let { a -> call.respond(a) } ?: call.respond(HttpStatusCode.NotFound)
    }
}