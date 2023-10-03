package serialization

import kotlinx.serialization.modules.SerializersModule
import java.time.LocalDate
import java.util.*

fun serializationModule() = SerializersModule {
    contextual(UUID::class, UUIDSerializer)
    contextual(LocalDate::class, LocalDateSerializer)
}