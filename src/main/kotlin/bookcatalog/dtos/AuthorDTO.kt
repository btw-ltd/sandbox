@file:UseSerializers(UUIDSerializer::class, LocalDateSerializer::class)

package bookcatalog.dtos

import kotlinx.serialization.UseSerializers
import kotlinx.serialization.Serializable
import util.LocalDateSerializer
import util.UUIDSerializer
import java.time.LocalDate
import java.util.*

@Serializable
data class AuthorDTO(
    val id: UUID,
    val name: String,
    val birthDate: LocalDate)