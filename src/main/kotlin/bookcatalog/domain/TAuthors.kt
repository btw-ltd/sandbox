package bookcatalog.domain

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.date
import java.time.LocalDate

object TAuthors : UUIDTable("authors") {
    val name: Column<String> = varchar("name", length = 50)
    val birthDate: Column<LocalDate> = date("birth_date")
}