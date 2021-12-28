fun main() {

    while (true) {
        val rawInput = readLine() ?: break

        val splitInput = rawInput.split(" ").toTypedArray()

        val command = splitInput[0]
        val args = splitInput.sliceArray(1 until splitInput.size)

        when (command) {
            "create" -> {
                val result = createRecord(
                    name = args[0],
                    color = args[1],
                    age = args[2].toInt(),
                    weight = args[3].toFloat()
                )
                if (result != null) {
                    printCat(result)
                } else {
                    println("Create: already exists")
                }
            }

            "update" -> {
                val result = updateRecord(
                    name = args[0],
                    color = args[1],
                    age = args[2].toInt(),
                    weight = args[3].toFloat()
                )
                if (result != null) {
                    printCat(result)
                } else {
                    println("Update: not found")
                }
            }

            "read" -> {
                val result = readRecord(key = args[0])
                if (result != null) {
                    printCat(result)
                } else {
                    println("Read: not found")
                }
            }

            "delete" -> {
                if (deleteRecord(key = args[0]) != null) {
                    println("OK")
                } else {
                    println("Delete: not found")
                }
            }

            "readall" -> printAllRecords()


            "where" -> {
                for (arg in args) {
                    val condition = arg.split("=", limit = 2).toTypedArray()
                    val field = condition[0]
                    val value = condition[1].toFloat()

                    when (field) {
                        "weight" -> {
                            printRecordsWhereWeight(value)
                        }
                    }
                }
            }
        }

    }
}