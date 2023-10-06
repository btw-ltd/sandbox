package bookcatalog.services

import bookcatalog.dao.AuthorDAO
import bookcatalog.domain.TAuthors
import bookcatalog.dtos.EditAuthorDTO
import bookcatalog.mappers.updateDAO
import org.jetbrains.exposed.sql.lowerCase
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class AuthorService {

    fun create(dto: EditAuthorDTO) = transaction {
        AuthorDAO.new(dto::updateDAO).id.value
    }

    fun update(id: UUID, dto: EditAuthorDTO) = transaction {
        AuthorDAO.findById(id)?.also(dto::updateDAO)
    }

    fun list() = transaction {
        AuthorDAO.all().toList()
    }

    fun findById(id: UUID) = transaction {
        AuthorDAO.findById(id)
    }

    fun findByName(name: String) = transaction {
        AuthorDAO.find {
            TAuthors.name.lowerCase().like("%${name.lowercase()}%")
        }.toList()
    }

    fun delete(id: UUID) = transaction {
        findById(id)?.apply {
            delete()
        }
    } != null
}