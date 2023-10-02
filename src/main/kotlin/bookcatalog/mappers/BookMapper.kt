package bookcatalog.mappers

import bookcatalog.dtos.BookDTO
import bookcatalog.models.Book

fun Book.toDTO() = BookDTO(id, title, author.toDTO(), synopsis, tags)

fun BookDTO.toDomain() = Book(id, title, author.toDomain(), synopsis, HashSet(tags))