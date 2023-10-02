package bookcatalog

import bookcatalog.services.AuthorService
import org.koin.dsl.module

val bookCatalogDI = module {
    single {
        AuthorService()
    }
}