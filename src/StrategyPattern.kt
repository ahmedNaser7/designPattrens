
// strategy pattern help you to avoid hardcoding algorithms

interface Payment{
    fun pay(amount:Int)
}


class CashPayment:Payment{
    override fun pay(amount: Int) {
        println("pay $amount using Cash")
    }

}


class CreditCardPayment:Payment{
    override fun pay(amount: Int) {
        println("pay $amount using CreditCard")
    }

}

class PayPalPayment:Payment{
    override fun pay(amount: Int) {
        println("pay $amount using PayPal")
    }

}

class PaymentContext{
    private  var paymentStrategy:Payment? = null

    fun setPaymentStrategy(payment: Payment?){
        this.paymentStrategy = payment
    }

    fun executePayment(amount: Int){
        if (paymentStrategy!=null){
            paymentStrategy!!.pay(amount)
        }else{
            println("no payment strategy set")
        }
    }
}

/**
 *   fun main() {
 *
 *   // design
 *
 *     // init
 *     val amount = 1000
 *     val paymentContext = PaymentContext()
 *
 *
 *     val cashPayment = CashPayment()
 *
 *     // use cash method
 *     paymentContext.setPaymentStrategy(cashPayment)
 *     paymentContext.executePayment(amount)
 *
 *     // use credit method
 *     paymentContext.setPaymentStrategy(CreditCardPayment())
 *     paymentContext.executePayment(amount)
 *
 *     // use PayPal method
 *     paymentContext.setPaymentStrategy(PayPalPayment())
 *     paymentContext.executePayment(amount)
 *
 *     // use nothing
 *     paymentContext.setPaymentStrategy(null)
 *     paymentContext.executePayment(amount)
 * }
 *
 *
 *
 * */