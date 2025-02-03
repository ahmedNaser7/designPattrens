/**
 * medium Link : https://medium.com/@akshatsharma0610/adapter-design-pattern-in-java-fa20d6df25b8
 *
 * concept of adapter
 * 1 - Target : interface or class client code expects to work with
 * 2 - adaptee : class that needs to be adapted
 * 3 - adapter : class that bridges the gap between the target and adaptee
 *
 */

// payment
// suppose that ( telda way) is not include in payments so will use adapter to handle this problem

// target
interface Payment{
    fun onPayment(money:Int)
}

// adaptee
class TeldaPayment{
    fun onTeldaPayment(money:Int) {
        print("telda on Payment = $money")
    }
}

// adapter
class PaymentAdapterToTeldaPayment():Payment{
    val teldaPayment = TeldaPayment()
    override fun onPayment(money: Int) {
        teldaPayment.onTeldaPayment(money)
    }
}

/**
 *   fun main() {
 *
 *
 *      val userPayment =  2000
 *      val adpter  =  PaymentAdapterToTeldaPayment()
 *      adpter.onPayment(userPayment)
 *
 *
 *     }
 *
 */