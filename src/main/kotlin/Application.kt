import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import kotlinx.serialization.json.Json
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import serialization.serializationModule

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    install(Koin) {
        slf4jLogger()
    }

    install(ContentNegotiation) {
        json(Json {
            serializersModule = serializationModule()
        })
    }

    install(Resources)

    DatabaseFactory.init()
}