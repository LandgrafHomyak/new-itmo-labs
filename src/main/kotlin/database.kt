data class Node(
    var prev: Node?,
    var next: Node?,
    val key: String,
    val value: Cat
)

var database: Node? = null

fun createRecord(
    name: String,
    color: String,
    age: Int,
    weight: Float
): Cat? {
    var pointer = database
    while (pointer != null) {
        if (pointer.key == name) {
            return null
        }
        pointer = pointer.next
    }

    pointer = Node(
        prev = null,
        next = database,
        key = name,
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
    var pointer = database
    while (pointer != null) {
        if (pointer.key == key) {
            return pointer.value
        }
        pointer = pointer.next
    }
    return null
}


fun deleteRecord(key: String): Cat? {
    var pointer = database
    while (pointer != null) {
        if (pointer.key == key) {
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