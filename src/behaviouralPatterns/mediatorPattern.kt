package behaviouralPatterns

// Airplane example

// colleague
interface Airplane{
    fun requestTakeOff()
    fun requestLanding()
    fun notifyAirTrafficControl(messege:String)
}

// concrete colleague
class AirplaneEgyptAir(
    private val airplaneTower: AirplaneTower
):Airplane{
    override fun requestTakeOff() {
        airplaneTower.requestTakeOff(this)
    }

    override fun requestLanding() {
        airplaneTower.requestLanding(this)
    }

    override fun notifyAirTrafficControl(messege:String) {
        println("AirplaneEgyptAir : $messege ")
    }
}

class AirplaneQatar(
    private val airplaneTower: AirplaneTower
):Airplane{
    override fun requestTakeOff() {
        airplaneTower.requestTakeOff(this)
    }

    override fun requestLanding() {
        airplaneTower.requestLanding(this)
    }

    override fun notifyAirTrafficControl(messege:String) {
        println("AirplaneQatar : $messege ")
    }
}


// mediator
interface AirplaneTower{
    fun requestTakeOff(airplane: Airplane)
    fun requestLanding(airplane: Airplane)
}


// concrete Mediator
class AirplaneTowerImpl:AirplaneTower{

    override fun requestTakeOff(airplane: Airplane) {
        // Logic of takeOff
        airplane.notifyAirTrafficControl("requesting takeOff successfully")
    }

    override fun requestLanding(airplane: Airplane) {
        // logic of landing
        airplane.notifyAirTrafficControl("requesting landing successfully")
    }
}

fun main(){

    // mediator
    val Tower = AirplaneTowerImpl()

    // colleague
    val airplane1 = AirplaneEgyptAir(Tower)
    val airplane2 = AirplaneQatar(Tower)

    airplane1.requestLanding()
    airplane2.requestTakeOff()


}



