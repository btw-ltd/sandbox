@file:UseSerializers(UUIDSerializer::class)

package bookcatalog.resources

import io.ktor.resources.*
import kotlinx.serialization.UseSerializers
import serialization.UUIDSerializer
import java.util.*

@Resource("/books")
class Books {

    @Resource("{id}")
    class Id(val parent: Books, val id: UUID) {

        @Resource("/name")
        class Name(val parent: Id)
    }
}