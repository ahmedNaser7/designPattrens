// State Pattern : The State pattern suggests creating separate classes for each
// state of the object and delegating state-specific behavior to these classes.
// components :
// 1-context
// 2-state
// 3-concrete state

// State
interface State {
    fun insertCoin()
    fun selectItem()
    fun dispenseItem()
}

// concrete state

class NoCoinState(
    private val vendingMachine: VendingMachine
) : State {
    override fun insertCoin() {
        println("coin inserted")
        vendingMachine.setState(HasCoinState(vendingMachine))
    }

    override fun selectItem() {
        println("please insert a coin first")
    }

    override fun dispenseItem() {
        println("Please insert a coin first")
    }
}

class HasCoinState(
    private val vendingMachine: VendingMachine
) : State {
    override fun insertCoin() {
        println("Coin Inserted already")
    }

    override fun selectItem() {
        println("Item selected")
        this.vendingMachine.setState(SoldState(vendingMachine))
    }

    override fun dispenseItem() {
        println("please Select Item First")
    }
}

class SoldState(
    private val vendingMachine: VendingMachine
) : State {
    override fun insertCoin() {
        println("Coin Inserted already")
    }

    override fun selectItem() {
        println("Coin selected already")
    }

    override fun dispenseItem() {
        println("Item dispensed")
        vendingMachine.setState(NoCoinState(vendingMachine))
    }
}


// context
class VendingMachine {
    private var state: State

    init {
        state = NoCoinState(this)
    }

    fun setState(currentState: State) {
        this.state = currentState
    }

    fun insertItem() {
        state.insertCoin()
    }

    fun selectItem() {
        state.selectItem()
    }

    fun dispenseItem() {
        state.dispenseItem()
    }
}

/**
 *   fun main() {
 *
 *   // design
 *
 *
 *   val vendingMachine = VendingMachine()
 *
 *     vendingMachine.insertItem()
 *     vendingMachine.selectItem()
 *     vendingMachine.dispenseItem()
 *
 * }
 *
 *
 * */
