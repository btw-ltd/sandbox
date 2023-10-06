import bookcatalog.domain.TAuthors
import bookcatalog.domain.TBooks
import bookcatalog.domain.TCustomerFavouriteBooks
import bookcatalog.domain.TCustomers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init() {
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:file:./build/db"
        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            SchemaUtils.create(TAuthors, TBooks, TCustomers, TCustomerFavouriteBooks)
        }
    }
}