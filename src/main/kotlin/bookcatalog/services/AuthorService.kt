package bookcatalog.services

import bookcatalog.models.Author
import java.time.LocalDate
import java.util.UUID

class AuthorService {

    private val authors = HashMap<UUID, Author>().apply {
        Author(UUID.randomUUID(), "J. R. R. Tolkien", LocalDate.of(1892, 1, 3)).let { put(it.id, it) }
        Author(UUID.randomUUID(), "Stephen Edwin King", LocalDate.of(1947, 9, 21)).let { put(it.id, it) }
    }

    fun create(name: String, birthDate: LocalDate) = UUID.randomUUID().also {
        authors[it] = Author(it, name, birthDate)
    }

    fun list() = authors.values.toList()

    fun findById(id: UUID) = authors[id]

    fun findByName(name: String) = authors.values.firstOrNull {
        it.name.contains(name, true)
    }

    fun delete(id: UUID) {
        authors.remove(id)
    }
}