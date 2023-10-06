package bookcatalog.services

import bookcatalog.dao.BookDAO
import bookcatalog.domain.TAuthors
import bookcatalog.domain.TBooks
import bookcatalog.mappers.toDTO
import org.jetbrains.exposed.dao.with
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.awt.print.Book
import java.util.*

class BookService {

    fun list() = transaction {
        BookDAO.all().map { it.toDTO() }
    }

    fun getTitle(id: UUID) = transaction {
        (TBooks innerJoin TAuthors).slice(TAuthors.name).select { TBooks.id eq id }.singleOrNull()?.get(TBooks.title)
    }

    fun findById(id: UUID) = transaction {
        BookDAO.findById(id)
    }
}