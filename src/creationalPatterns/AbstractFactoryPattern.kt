package creationalPatterns


interface Button {
    fun onClick(action: String)
    fun render()
}

interface CheckBox {
    fun onClick(action: String)
    fun render()
}

// products
class WindowsButton : Button {
    override fun onClick(action: String) {
        println("Windows button clicked on: $action")
    }

    override fun render() {
        println("rendered Windows button")
    }
}

class MacButton : Button {
    override fun onClick(action: String) {
        println("Mac button clicked on: $action")
    }

    override fun render() {
        println("rendered Mac button")
    }
}

class WindowsCheckBox : CheckBox {
    override fun onClick(action: String) {
        println("Windows Checkbox clicked on: $action")
    }

    override fun render() {
        println("rendered Windows Checkbox")
    }
}

class MacCheckBox : CheckBox {
    override fun onClick(action: String) {
        println("Mac Checkbox clicked on: $action")
    }

    override fun render() {
        println("rendered Mac Checkbox")
    }
}

// creator
interface GUIFactory {
    // all represent Abstract Methods
    // Factory Method
    fun createButton(): Button
    fun createCheckBox(): CheckBox
}

class WindowsFactory() : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckBox(): CheckBox {
        return WindowsCheckBox()
    }
}

class MacFactory() : GUIFactory {
    override fun createButton(): Button {
        return MacButton()
    }

    override fun createCheckBox(): CheckBox {
        return MacCheckBox()
    }
}

class Application(
    private val factory: GUIFactory
) {
    private lateinit var button: Button
    private lateinit var checkBox: CheckBox

    fun createUi() {
        button = this.factory.createButton()
        checkBox = this.factory.createCheckBox()
    }

    fun paint() {
        button.render()
        checkBox.render()
    }

    fun onClickButton(action: String) {
        button.onClick(action)
    }

    fun onClickCheckBox(action: String) {
        checkBox.onClick(action)
    }
}

fun main(){
//    val osConfig = WindowsFactory()
    val osConfig = MacFactory()
    val application = Application(osConfig)
    application.createUi()
    application.paint()
    application.onClickButton("Go To Home Screen")
    application.onClickCheckBox("True")
}

