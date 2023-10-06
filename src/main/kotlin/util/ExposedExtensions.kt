package util

import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.SizedIterable

operator fun <T> SizedIterable<T>.plus(item: T) = SizedCollection(this.toMutableList() + item)