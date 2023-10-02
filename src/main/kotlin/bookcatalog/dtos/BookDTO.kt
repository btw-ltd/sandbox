package bookcatalog.dtos

import java.util.UUID

data class BookDTO(val id: UUID, val title: String, val author: AuthorDTO, val synopsis: String, val tags: Set<String>)
