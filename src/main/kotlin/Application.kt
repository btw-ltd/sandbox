import bookcatalog.bookCatalogDI
import bookcatalog.bookCatalogModule
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    install(Koin) {
        slf4jLogger()
        modules(bookCatalogDI)
    }

    install(ContentNegotiation) {
        json()
    }

    install(Resources)

    bookCatalogModule()
}