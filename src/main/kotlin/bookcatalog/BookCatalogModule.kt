package bookcatalog

import bookcatalog.routes.authorRoutes
import bookcatalog.routes.bookRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.koin

fun Application.module() {

    koin {
        modules(bookCatalogDI())
    }

    routing {
        authorRoutes()
        bookRoutes()
    }
}