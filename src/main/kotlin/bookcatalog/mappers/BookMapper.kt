package bookcatalog.mappers

import bookcatalog.dao.BookDAO
import bookcatalog.dtos.BookDTO

fun BookDAO.toDTO() = BookDTO(id.value, title, author.toDTO(), synopsis)
