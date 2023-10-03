package bookcatalog.dao

import bookcatalog.domain.TAuthors
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class AuthorDAO(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<AuthorDAO>(TAuthors)

    var name by TAuthors.name
    var birthDate by TAuthors.birthDate
}