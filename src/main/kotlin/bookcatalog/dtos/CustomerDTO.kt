@file:UseContextualSerialization(UUID::class)

package bookcatalog.dtos

import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization
import java.util.*

@Serializable
data class CustomerDTO(
    val id: UUID,
    val name: String)