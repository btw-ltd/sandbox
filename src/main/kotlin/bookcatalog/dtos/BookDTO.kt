@file:UseContextualSerialization(UUID::class)

package bookcatalog.dtos

import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization
import java.util.*

@Serializable
data class BookDTO(val id: UUID, val title: String, val author: AuthorDTO, val synopsis: String, val tags: Set<String> = emptySet())
