package bookcatalog.domain

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import java.util.UUID

object TBooks : UUIDTable("books") {
    val title: Column<String> = varchar("title", length = 50)
    val authorId: Column<UUID> = uuid("author_id").references(TAuthors.id)
    val synopsis: Column<String> = text("synopsis")
}