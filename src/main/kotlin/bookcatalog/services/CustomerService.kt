package bookcatalog.services

import bookcatalog.dao.CustomerDAO
import bookcatalog.domain.TCustomers
import bookcatalog.dtos.EditCustomerDTO
import bookcatalog.mappers.updateDAO
import org.jetbrains.exposed.sql.lowerCase
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import util.plus

class CustomerService(val bookService: BookService) {

    fun create(dto: EditCustomerDTO) = transaction {
        CustomerDAO.new(dto::updateDAO).id.value
    }

    fun update(id: UUID, dto: EditCustomerDTO) = transaction {
        CustomerDAO.findById(id)?.also(dto::updateDAO)
    }

    fun list() = transaction {
        CustomerDAO.all().toList()
    }

    fun findById(id: UUID) = transaction {
        CustomerDAO.findById(id)
    }

    fun findByName(name: String) = transaction {
        CustomerDAO.find {
            TCustomers.name.lowerCase().like("%${name.lowercase()}%")
        }.toList()
    }

    fun delete(id: UUID) = transaction {
        findById(id)?.apply {
            delete()
        }
    } != null

    fun addFavouriteBook(id: UUID, bookId: UUID) = transaction {
        findById(id)?.apply {
            bookService.findById(bookId)?.let {
                favouriteBooks += it
                return@transaction true
            }
        }
        false
    }
}