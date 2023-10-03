package bookcatalog.dao

import bookcatalog.domain.TBooks
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class BookDAO(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<BookDAO>(TBooks)

    var title by TBooks.title
    var author by AuthorDAO referencedOn TBooks.authorId
    var synopsis by TBooks.synopsis
}