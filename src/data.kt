data class Cat(
    val name: String,
    var color: String,
    var age: Int,
    var weight: Float
)

fun printCat(cat: Cat) {
    println("Cat: name=\"${cat.name}\", color=\"${cat.color}\", age=${cat.age}, weight=${cat.weight}")
}