const val databaseSize = 1000

val databaseKeys = Array<String?>(databaseSize) { null }
val databaseValues = Array<Cat?>(databaseSize) { null }

fun createRecord(
    name: String,
    color: String,
    age: Int,
    weight: Int
): Cat? {
    for (i in 0 until databaseSize) {
        if (databaseKeys[i] == null) {
            databaseKeys[i] = name
            databaseValues[i] = Cat(
                name = name,
                color = color,
                age = age,
                weight = weight
            )
            return databaseValues[i]!! // проверку !! можно было сделать через локальную переменную
        }
    }
    return null
}

fun readRecord(key: String): Cat? {
    for (i in 0 until databaseSize) {
        if (databaseKeys[i] == key) {
            return databaseValues[i]!! // !! просто для красоты и надёжности, первокурсники могут не додуматься т.к. не получится сделать возвращаемый тип not null
        }
    }
    return null
}


fun deleteRecord(key: String) {
    for (i in 0 until databaseSize) {
        if (databaseKeys[i] == key) {
            databaseKeys[i] = null
            databaseValues[i] = null
        }
    }
}

fun printAllRecords() {
    for (i in 0 until databaseSize) {
        /* if (databaseKeys[i] != null) { printCat(databaseValues[i]!!) } */
        if (databaseValues[i] != null) {
            printCat(databaseValues[i]!!) // проверку !! можно было сделать через локальную переменную
        }
    }
}