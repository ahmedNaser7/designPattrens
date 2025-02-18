package creationalPatterns



interface Shape{
    fun clone():Shape
    fun getName():String
}

class Circle(
    private val name: String
):Shape{
    override fun clone(): Shape {
        return this
    }

    override fun getName(): String {
       return name
    }
}

class Square(
    private val name: String
):Shape{
    override fun clone(): Shape {
        return this
    }

    override fun getName(): String {
        return name
    }
}

fun main(){
    val shapes = mutableListOf<Shape>()
    val circle = Circle("Red circle")
    val anotherCircle = circle.clone()
    val square = Square("Blue Square")
    val anotherSquare = square.clone()
    shapes.add(circle)
    shapes.add(square)
    shapes.add(anotherCircle)
    shapes.add(anotherSquare)

    shapes.forEach { println(it.getName()) }
}