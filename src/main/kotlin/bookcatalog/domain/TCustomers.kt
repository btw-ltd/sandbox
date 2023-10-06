package bookcatalog.domain

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column

object TCustomers : UUIDTable("customers") {
    val name: Column<String> = varchar("name", length = 50)
}