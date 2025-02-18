package creationalPatterns

// car builder
// manual Or auto

data class Manual(
    var seats:Int,
    var color:String
)

data class Auto(
    var seats:Int,
    var color:String
)

interface Builder{
    fun reset()
    fun setSeats(number:Int)
    fun setColor(color: String)
}

class CarManualBuilder:Builder{
    // result
    private lateinit var manual:Manual
    override fun reset() {
        this.manual = Manual(0,"")
    }

    override fun setSeats(number: Int) {
        manual.seats = number
    }

    override fun setColor(color: String) {
        manual.color = color
    }
    fun getProduct():Manual{
        val product = this.manual
        reset()
        return product
    }
}

class CarAutoBuilder:Builder{
    // result
    private lateinit var auto:Auto
    override fun reset() {
        this.auto = Auto(0,"")
    }

    override fun setSeats(number: Int) {
        auto.seats = number
    }

    override fun setColor(color: String) {
        auto.color = color
    }
    fun getProduct():Auto{
        val product = this.auto
        reset()
        return product
    }
}

class Director{
    private lateinit var builder:Builder
    fun setBuilder(builder: Builder){
        this.builder = builder
    }
    fun constructTeslaCar(builder: Builder){
        builder.reset()
        builder.setColor("gray")
        builder.setSeats(4)
    }
    fun constructVernaCar(builder: Builder){
        builder.reset()
        builder.setSeats(2)
        builder.setColor("Blue")
    }
}

fun main(){
    // director
    val director = Director()

    // build tesla car
    val autoBuilder = CarAutoBuilder()
    director.constructTeslaCar(autoBuilder)
    val tesla = autoBuilder.getProduct()
    println(tesla)

    // build verna car
    val manualBuilder = CarManualBuilder()
    director.constructVernaCar(manualBuilder)
    val verna  = manualBuilder.getProduct()
    println(verna)
}



