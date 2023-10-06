package bookcatalog.dao

import bookcatalog.domain.TCustomerFavouriteBooks
import bookcatalog.domain.TCustomers
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class CustomerDAO(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<CustomerDAO>(TCustomers)

    var name by TCustomers.name

    var favouriteBooks by BookDAO via TCustomerFavouriteBooks
}