package behaviouralPatterns// The Chain of Responsibility pattern is a behavioral design pattern
// that allows multiple objects to handle a request
// without specifying the exact handler explicitly.

// Example from Head First Design Patterns (Java)
//Let’s use the example of handling expense reports in a company. Different managers have different approval limits:
//Junior Manager can approve expenses up to $500.
//Senior Manager can approve expenses up to $1000.
//Director can approve expenses up to $5000.
//If no one can handle the request, it goes unapproved.


data class Expense(
    val amount: Double
)

interface Approver {
    fun setNextApprover(nextApprover: Approver)
    fun processRequest(expense: Expense)
}

class JuniorManager(
): Approver {
    private lateinit var nextApprover: Approver
    override fun setNextApprover(nextApprover: Approver) {
          this.nextApprover = nextApprover
    }

    override fun processRequest(expense: Expense) {
        if (expense.amount<=500)
            println("Junior Manager approves the expense of ${expense.amount}")
        else
           nextApprover.processRequest(expense)
    }
}

class SeniorManager(
): Approver {
    private lateinit var nextApprover: Approver
    override fun setNextApprover(nextApprover: Approver) {
        this.nextApprover = nextApprover
    }

    override fun processRequest(expense: Expense) {
        if (expense.amount<=1000)
            println("Senior Manager approves the expense of ${expense.amount}")
        else
            nextApprover.processRequest(expense)
    }
}

class DirectorManager(
): Approver {
    private lateinit var nextApprover: Approver
    override fun setNextApprover(nextApprover: Approver) {
        this.nextApprover = nextApprover
    }

    override fun processRequest(expense: Expense) {
        if (expense.amount<=5000)
            println("Director Manager approves the expense of ${expense.amount}")
        else
            println("there is not approves the expense of ${expense.amount}")
    }
}

/**
 *   fun main() {
 *
 *   // design
 *
 *     val expense1 = Expense(100.0)
 *     val expense2 = Expense(600.0)
 *     val expense3 = Expense(2000.0)
 *     val expense4 = Expense(6000.0)
 *
 *     //  handler classes
 *     val handler = JuniorManager() // junior
 *     val seniorManager = SeniorManager()
 *     val director = DirectorManager()
 *
 *     // set next approver
 *     handler.setNextApprover(seniorManager)
 *     seniorManager.setNextApprover(director)
 *
 *     // send request
 *     // junior  ---> senior ---> director ---> not found
 *     handler.processRequest(expense1)
 *     handler.processRequest(expense2)
 *     handler.processRequest(expense3)
 *     handler.processRequest(expense4)
 * }
 *
 * */
