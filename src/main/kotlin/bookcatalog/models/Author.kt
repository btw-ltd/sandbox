package bookcatalog.models

import java.time.LocalDate
import java.util.UUID

data class Author(var id: UUID, var name: String, var birthDate: LocalDate)
