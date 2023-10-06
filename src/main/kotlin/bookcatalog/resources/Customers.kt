@file:UseSerializers(UUIDSerializer::class)

package bookcatalog.resources

import io.ktor.resources.*
import kotlinx.serialization.UseSerializers
import util.SortOrder
import serialization.UUIDSerializer
import java.util.UUID

@Resource("/customers")
class Customers(val order: SortOrder? = SortOrder.ASC) {

    @Resource("{id}")
    class Id(val parent: Customers, val id: UUID) {

        @Resource("/favourites")
        class Favourites(val parent: Id)
    }

    @Resource("/search")
    class Search(val parent: Customers, val name: String?)

    @Resource("/test")
    class Test()
}