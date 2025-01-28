/*
    // TODO:
        Subject <<interface>> --> has a list of --> Observer<<interface>>
                   |                                        |
                   |                                        |
              implements.                              implements.
                   |                                        |
                   |                                        |
        WeatherData<class>                              Phone<class>
        start:
            - create object of phone class "implements Observer"
            - register it with WeatherData class "implements Subject" - add it to list of observers -
            - set new measurements "setTemp()" -> call update function in each observer "OBSERVING"
            - subject --- notify ---> observer
            - subject <--- observe --- observer "observe by implementing update function of the Observer interface"

 */
interface Subject {
    fun register(observer: Observer)
    fun remove(observer: Observer)
    fun notifyObserver()
}

interface Observer{
    fun update(temp: Int)
}

class WeatherData: Subject{

    private val observers: MutableList<Observer> = mutableListOf()
    private var temp: Int = 0

    override fun register(observer: Observer) {
        observers.add(observer)
    }

    override fun remove(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObserver() {
        observers.forEach {
            it.update(temp)
        }
    }

    fun setTemp(newTemp: Int){
        temp = newTemp
        notifyObserver()
    }
}

class Phone: Observer{
    override fun update(temp: Int) {
        println("Phone updated: $temp")
    }
}

class Monitor: Observer{
    override fun update(temp: Int) {
        println("Monitor  updated: $temp")
    }
}

/**
 * fun main() {
 *
 *     val weatherData = WeatherData()
 *
 *     val phoneObserver = Phone()
 *     weatherData.register(phoneObserver)
 *     val monitorObserver = Monitor()
 *     weatherData.register(monitorObserver)
 *
 *     weatherData.setTemp(25)
 * }
 */