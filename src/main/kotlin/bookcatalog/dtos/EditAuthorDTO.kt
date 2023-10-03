@file:UseContextualSerialization(LocalDate::class)

package bookcatalog.dtos

import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization
import java.time.LocalDate

@Serializable
data class EditAuthorDTO(
    val name: String,
    val birthDate: LocalDate)