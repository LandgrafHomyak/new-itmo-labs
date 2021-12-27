data class Cat(
    val name: String,
    val color: String,
    val age: Int,
    val weight: Float
)

fun printCat(cat: Cat) {
    println("Cat: name=\"${cat.name}\", color=\"${cat.color}\", age=${cat.age}, weight=${cat.weight}")
}