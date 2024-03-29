@file:UseContextualSerialization(UUID::class, LocalDate::class)

package bookcatalog.dtos

import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization
import java.time.LocalDate
import java.util.*

@Serializable
data class AuthorDTO(
    val id: UUID,
    val name: String,
    val birthDate: LocalDate)