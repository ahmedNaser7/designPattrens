package behaviouralPatterns

// text editor to retrieve data

class TextEditor {
    private var content: String = ""

    fun setText(text: String){
        this.content = text
    }
    fun getText():String{
        return content
    }
    fun saveStateToMomento(): ConcreteMomento {
        return ConcreteMomento(content)
    }

    fun getStateFromMemento(momento: ConcreteMomento){
        momento.getState()
    }
}


class ConcreteMomento(
     content: String
)  {
    private val state:String = content
    fun getState():String{
        return state
    }
}

// careTaker
class  History(){
    private val momentos:MutableList<ConcreteMomento> = mutableListOf()

    fun addMomento(momento: ConcreteMomento){
         momentos.add(momento)
    }
    fun get(index:Int):ConcreteMomento{
        return momentos[index]
    }

    fun displayAllState(){
        momentos.forEach {
            println(it.getState())
        }
    }
}

fun main(){
    // init
    // originator
    val textEditor = TextEditor()
    // careTaker
    val history = History()

    textEditor.setText("init state")
    history.addMomento(textEditor.saveStateToMomento())

    textEditor.setText("second state")
    history.addMomento(textEditor.saveStateToMomento())

    // previous state
    println(history.get(0).getState())

    // print all state
    history.displayAllState()

}