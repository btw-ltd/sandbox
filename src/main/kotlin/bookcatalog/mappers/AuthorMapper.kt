package bookcatalog.mappers

import bookcatalog.dao.AuthorDAO
import bookcatalog.dtos.AuthorDTO
import bookcatalog.dtos.EditAuthorDTO

fun AuthorDAO.toDTO() = AuthorDTO(id.value, name, birthDate)

fun EditAuthorDTO.updateDAO(dao: AuthorDAO) {
    dao.name = name
    dao.birthDate = birthDate
}