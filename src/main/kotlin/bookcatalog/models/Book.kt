package bookcatalog.models

import java.util.UUID

data class Book(var id: UUID, var title: String, var author: Author, var synopsis: String, var tags: MutableSet<String> = HashSet())
