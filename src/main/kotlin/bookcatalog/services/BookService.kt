package bookcatalog.services

import bookcatalog.dao.BookDAO
import bookcatalog.domain.TAuthors
import bookcatalog.domain.TBooks
import bookcatalog.mappers.toDTO
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class BookService {

    fun getTitle(id: UUID) = transaction {
        (TBooks innerJoin TAuthors).slice(TAuthors.name).select { TBooks.id eq id }.singleOrNull()?.get(TBooks.title)
    }

    fun findById(id: UUID) = transaction {
        BookDAO.findById(id)?.toDTO()
    }
}