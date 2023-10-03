package util

enum class SortOrder {
    ASC, DESC
}

inline fun <T, R : Comparable<R>> Collection<T>.sorted(order: SortOrder?, crossinline selector: (T) -> R?) = when(order) {
    null, SortOrder.ASC -> sortedBy(selector)
    SortOrder.DESC -> sortedByDescending(selector)
}