package behaviouralPatterns// command is a behavioural pattern that decouples the object

// command
interface Command {
    fun execute()
    fun undo()
}

// Receiver
class Light() {
    fun onLight() {
        println("turn on the light")
    }

    fun offLight() {
        println("turn off the light")
    }
}

// concrete command
class LightOnCommand(
    private val light: Light
) : Command {
    override fun execute() {
        light.onLight()
    }

    override fun undo() {
        light.offLight()
    }

}

class LightOffCommand(
    private val light: Light
) : Command {
    override fun execute() {
        light.offLight()
    }

    override fun undo() {
        light.onLight()
    }
}

// Invoker
class RemoteControl{
    private var command: Command?=null
    fun setCommend(command: Command){
        this.command = command
    }
    fun deleteCommand(){
        println("command deleted successfully")
        command = null
    }
    // button to turn on/off light
    fun pressButton(){
        command?.execute()
    }

    fun pressUndo(){
        command?.undo()
    }
}

/**
 *     fun main() {
 *
 *     // receiver
 *     val light = Light()
 *
 *     // commands
 *     val turnOnLight = LightOnCommand(light)
 *     val turnOffLight = LightOffCommand(light)
 *
 *     // invoker
 *     val remoteControl = RemoteControl()
 *
 *     // orders
 *     // turn on light
 *     remoteControl.setCommend(turnOnLight)
 *     remoteControl.pressButton()
 *     remoteControl.pressUndo()
 *
 *     // turn off light
 *     remoteControl.setCommend(turnOffLight)
 *     remoteControl.pressButton()
 *     remoteControl.pressUndo()
 *
 *     // delete command
 *     remoteControl.deleteCommand()
 *
 * }
 *
 *
 *
 * */
