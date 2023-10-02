package bookcatalog.mappers

import bookcatalog.dtos.AuthorDTO
import bookcatalog.models.Author

fun Author.toDTO() = AuthorDTO(id, name, birthDate)

fun AuthorDTO.toDomain() = Author(id, name, birthDate)