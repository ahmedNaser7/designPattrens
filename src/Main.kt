//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val weatherData = WeatherData()

    val phoneObserver = Phone()
    weatherData.register(phoneObserver)
    val monitorObserver = Monitor()
    weatherData.register(monitorObserver)

    weatherData.setTemp(25)
}