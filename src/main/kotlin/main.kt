fun main() {

    while (true) {
        val rawInput = readLine() ?: break

        val splitInput = rawInput.split(" ").toTypedArray()

        val command = splitInput[0]
        val args = splitInput.sliceArray(1 until splitInput.size)

        when (command) {
            "create" -> printCat(
                createRecord(
                    name = args[0],
                    color = args[1],
                    age = args[2].toInt(),
                    weight = args[3].toInt()
                )!!
            )

            "read" -> printCat(readRecord(key = args[0])!!)

            "delete" -> {
                deleteRecord(key = args[0])
                println("OK")
            }

            "readall" -> printAllRecords()
        }

    }


}