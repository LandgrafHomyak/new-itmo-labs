import kotlin.math.abs

const val epsilon = 1e-3;

data class Node(
    var prev: Node?,
    var next: Node?,
    val key: Int,
    val value: Cat
)

fun hashString(str: String): Int {
    var hash: Int = 0
    var p = 3
    for (c in str) {
        hash += c.code * p
        p *= 3
    }
    return hash
}

var database: Node? = null

fun createRecord(
    name: String,
    color: String,
    age: Int,
    weight: Float
): Cat? {
    val hKey = hashString(name)
    var pointer = database
    while (pointer != null) {
        if (pointer.key == hKey) {
            return null
        }
        pointer = pointer.next
    }

    pointer = Node(
        prev = null,
        next = database,
        key = hKey,
        value = Cat(
            name = name,
            color = color,
            age = age,
            weight = weight
        )
    )
    database?.prev = pointer
    database = pointer

    return pointer.value
}

fun readRecord(key: String): Cat? {
    val hKey = hashString(key)
    var pointer = database
    while (pointer != null) {
        if (pointer.key == hKey) {
            return pointer.value
        }
        pointer = pointer.next
    }
    return null
}


fun deleteRecord(key: String): Cat? {
    val hKey = hashString(key)
    var pointer = database
    while (pointer != null) {
        if (pointer.key == hKey) {
            pointer.prev?.next = pointer.next
            pointer.next?.prev = pointer.prev
            if (database === pointer) {
                database = pointer.next
            }
            return pointer.value
        }
        pointer = pointer.next
    }
    return null
}

fun printAllRecords() {
    var pointer = database
    while (pointer != null) {
        printCat(pointer.value)
        pointer = pointer.next
    }
}


fun updateRecord(
    name: String,
    color: String,
    age: Int,
    weight: Float
): Cat? {
    val hKey = hashString(name)
    var pointer = database
    while (pointer != null) {
        if (pointer.key == hKey) {
            pointer.value.color = color
            pointer.value.age = age
            pointer.value.weight = weight
            return pointer.value
        }
        pointer = pointer.next
    }
    return null
}

/*
fun printSelectedRecords(
    name: String?,
    color: String?,
    age: Int?,
    weight: Float?
) {
    var pointer = database
    while (pointer != null) {
        if (name != null && pointer.value.name != name) {
            continue
        }
        if (color != null && pointer.value.color != color) {
            continue
        }
        if (age != null && pointer.value.age != age) {
            continue
        }
        if (weight != null && abs(pointer.value.weight - weight) > epsilon) {
            continue
        }
        printCat(pointer.value)

        pointer = pointer.next
    }
}
*/

fun printRecordsWhereWeight(weight: Float) {
    var pointer = database
    while (pointer != null) {
        if (abs(pointer.value.weight - weight) <= epsilon) {
            printCat(pointer.value)
        }

        pointer = pointer.next
    }
}