package behaviouralPatterns

// how to make beverages
// tea
// coffee

// Template Abstract
abstract class Beverage(){
    // template methods
    fun makeBeverage(){
        boilWater()
        brew()
        pourInWater()
        addCondiments()
        println()
    }
    private fun boilWater(){
        println("Boiling  water")
    }
    private fun pourInWater(){
        println("pouring in water")
    }
    // hook (abstract method)
    abstract fun brew ()
    abstract fun addCondiments()
}

class TeaMaker:Beverage(){
    override fun brew() {
        println("Steeping the tea")
    }

    override fun addCondiments() {
        println("Adding Sugar and lemon")
    }
}

class CoffeeMaker():Beverage(){
    override fun brew() {
        println("Dripping coffee through filter")
    }

    override fun addCondiments() {
        println("Adding cream and milk")
    }
}

fun main(){
    // makers
    val teaMaker:Beverage = TeaMaker()
    val coffeeMaker:Beverage = CoffeeMaker()

    // display template method
    teaMaker.makeBeverage()
    coffeeMaker.makeBeverage()

}