package behaviouralPatterns

import java.lang.Math.PI
import kotlin.math.pow

// calculate the area of shapes

// visitor
interface ShapeVisitor{
    fun visit(circle:Circle)
    fun visit(square: Square)
    fun visit(triangle: Triangle)
}

class AreaCalculator():ShapeVisitor{
    private var totalArea:Double = 0.0
    override fun visit(circle: Circle) {
        totalArea += PI * circle.getRadiusOfCircle().pow(2)
        println("Circle Area : $totalArea")
    }

    override fun visit(square: Square) {
        totalArea += 4 * square.getSideOfSquare()
        println("Square Area : ${4 * square.getSideOfSquare()}")
    }

    override fun visit(triangle: Triangle) {
        totalArea += (triangle.getBaseOfTriangle() + triangle.getHeightOfTriangle()) / 2
        println("Triangle Area : ${(triangle.getBaseOfTriangle() + triangle.getHeightOfTriangle()) / 2}")
    }

    fun getTotalArea() = println("totalArea : $totalArea")
}

interface Shape{
    fun acceptVisitor(visitor: ShapeVisitor)
}

class Circle(
    private val radiusOfCircle:Double
):Shape {
    override fun acceptVisitor(visitor: ShapeVisitor) {
        visitor.visit(this)
    }
    fun getRadiusOfCircle():Double = radiusOfCircle
}
class Square(
    private val sideOfSquare:Double,
):Shape {
    override fun acceptVisitor(visitor: ShapeVisitor) {
        visitor.visit(this)
    }
    fun getSideOfSquare():Double = sideOfSquare
}
class Triangle(
    private val baseOfTriangle:Double,
    private val heightOfTriangle:Double
):Shape {
    override fun acceptVisitor(visitor: ShapeVisitor) {
        visitor.visit(this)
    }
    fun getBaseOfTriangle():Double = baseOfTriangle
    fun getHeightOfTriangle():Double = heightOfTriangle
}

fun main(){
    val areaCalculator = AreaCalculator()
    val circle = Circle(20.0)
    val square = Square(50.0)
    val triangle = Triangle(34.5,55.7)

    circle.acceptVisitor(areaCalculator)
    square.acceptVisitor(areaCalculator)
    triangle.acceptVisitor(areaCalculator)

    areaCalculator.getTotalArea()
}
