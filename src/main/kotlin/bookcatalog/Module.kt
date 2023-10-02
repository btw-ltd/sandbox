package bookcatalog

import bookcatalog.routes.authorRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.bookCatalogModule() {

    routing {
        authorRoutes()
    }
}