package bookcatalog

import bookcatalog.services.AuthorService
import bookcatalog.services.BookService
import bookcatalog.services.CustomerService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun bookCatalogDI() = module {
    singleOf(::AuthorService)
    singleOf(::BookService)
    singleOf(::CustomerService)
}