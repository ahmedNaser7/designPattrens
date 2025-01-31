/**

 medium Link : https://medium.com/@akshatsharma0610/composite-design-pattern-b1ebd0756aa9
                             +-------------------+
                             |   Component       |
                             |-------------------|
                             | + operation()     |
                             +-------------------+
                              /                 \
                             /                   \
                            /                     \
                           /                       \
                         +--------+      +-------------------+
                         |  Leaf  |      |   Composite       |
                         |--------|      |-------------------|
                         | + op() |      | + operation()     |
                         +--------+      | + add(Component)  |
                                         | + remove(Component)|
                                         | + getChild(int)    |
                                          +-------------------+
                                                 |
                                                 |
                                                 v
                                           +-----------------+
                                           |  Child Components |
                                           |  (Leaf/Composite) |
                                            +-----------------+

     - Component : base interface for all objects
     - Leaf : doesn't have a chile of ref to the other objects
     - composite: has leaf elements

    ex
 Component
 ├── Leaf (hdd, 4000)
 ├── Leaf (keyboard, 1000)
 ├── Leaf (mouse, 500)
 ├── Leaf (ram, 3000)
 ├── Leaf (Processor, 10000)
 │
 ├── Composite (computer)
 │   ├── Composite (Hardware)
 │   │   ├── Leaf (hdd, 4000)
 │   │   └── Composite (motherboard)
 │   │       ├── Leaf (ram, 3000)
 │   │       └── Leaf (Processor, 10000)
 │   │
 │   └── Composite (Software)
 │       ├── Leaf (keyboard, 1000)
 │       └── Leaf (mouse, 500)
 │
 └── (All components are part of the "computer" composite)

 */

interface Component{
    fun showPrice()
    fun showName()
}

class Leaf(
    private val name:String,
    private val price:Double
):Component{

    override fun showPrice() {
        println(price)
    }

    override fun showName() {
        println(name)
    }
}

class Composite(
    val name:String
):Component{
    var components:MutableList<Component> = mutableListOf()

    override fun showPrice() {
       components.forEach {
           println(it.showPrice())
       }
    }

    override fun showName() {
        components.forEach {
            println(it.showName())
        }
    }

    fun add(subComponent:Component){
        components.add(subComponent)
    }
}

/**
 * fun main() {
 *
 *    // computer
 *     // hardware  // mouse , keyboard
 *     // software // motherBoard(Ram , Processor)    //Hdd
 *
 *     // leafs
 *     val mouse = Leaf("Mouse",90.0)
 *     val keyboard = Leaf("keyboard",120.0)
 *     val hdd= Leaf("Hdd",1220.0)
 *     val processor = Leaf("Processor",4220.0)
 *     val ram = Leaf("Ram",800.0)
 *
 *     // component
 *     val computer = Composite("Computer")
 *
 *     // composite
 *     val motherBoard = Composite("Motherboard")
 *     motherBoard.add(ram)
 *     motherBoard.add(processor)
 *
 *     val hardware = Composite("Hardware")
 *     hardware.add(mouse)
 *     hardware.add(keyboard)
 *
 *     val software = Composite("Software")
 *     software.add(motherBoard)
 *     software.add(hdd)
 *
 *     computer.add(hardware)
 *     computer.add(software)
 *
 *     computer.showName()
 *     computer.showPrice()
 *
 * }
 *
 */