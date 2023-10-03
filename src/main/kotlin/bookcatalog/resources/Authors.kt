@file:UseSerializers(UUIDSerializer::class)

package bookcatalog.resources

import io.ktor.resources.*
import kotlinx.serialization.UseSerializers
import util.SortOrder
import serialization.UUIDSerializer
import java.util.UUID

@Resource("/authors")
class Authors(val order: SortOrder? = SortOrder.ASC) {

    @Resource("{id}")
    class Id(val parent: Authors, val id: UUID)

    @Resource("/search")
    class Search(val parent: Authors, val name: String?)
}