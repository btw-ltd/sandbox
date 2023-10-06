package bookcatalog.domain

import org.jetbrains.exposed.sql.Table

object TCustomerFavouriteBooks : Table("join_customers_books") {
    val customer = reference("customer", TCustomers)
    val book = reference("book", TBooks)
    override val primaryKey = PrimaryKey(customer, book)
}