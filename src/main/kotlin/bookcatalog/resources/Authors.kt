@file:UseSerializers(UUIDSerializer::class)

package bookcatalog.resources

import io.ktor.resources.*
import kotlinx.serialization.UseSerializers
import util.SortOrder
import util.UUIDSerializer
import java.util.UUID

@Resource("/authors")
class Authors(val order: SortOrder? = SortOrder.ASC) {

    @Resource("add")
    class Add(val parent: Authors = Authors())

    @Resource("{id}")
    class Id(val parent: Authors = Authors(), val id: UUID) {

        @Resource("edit")
        class Edit(val parent: Id)
    }
}