package bookcatalog.services

import bookcatalog.models.Author
import bookcatalog.models.Book
import java.time.LocalDate
import java.util.UUID

class BookService {

    private val books = HashMap<UUID, Book>()

    fun create(title: String, author: Author, synopsis: String) = UUID.randomUUID().also {
        books[it] = Book(it, title, author, synopsis)
    }

    fun list() = books.values.toList()

    fun findById(id: UUID) = books[id]

    fun findByTitle(title: String) = books.values.firstOrNull {
        it.title.contains(title, true)
    }

    fun addTag(id: UUID, tag: String) {
        findById(id)?.tags?.add(tag)
    }

    fun delete(id: UUID) {
        books.remove(id)
    }
}