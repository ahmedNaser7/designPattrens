package structuralPatterns// The Proxy Pattern provides
// a representative for another object in order to control the client’s access to it.
// Subject & Real Subject & Proxy
/**
            +-------------------+          +-------------------+
            |      Image        |          |    RealImage      |
            |-------------------|          |-------------------|
            | + display(): void |<|--------| - imageUrl: String|
            +-------------------+          |-------------------|
            /\                             | + display(): void |
            |                              +-------------------+
            |                                      /\
            |                                      |
            |                                      |
            +-------------------+                  |
            |    ProxyImage     |                  |
            |-------------------|                  |
            | - fileName: String|                  |
            | - realImage: Image|------------------|
            |-------------------|
            | + display(): void |
            +-------------------+
 */

// subject
interface Image{
    fun display()
}

// Real-Subject
class RealImage(
    val imageUrl:String
): Image {
    override fun display() {
        println(imageUrl)
    }
}

// proxy
class ProxyImage(
    val fileName:String
): Image {
     var realImage: Image? = null
    override fun display() {
        if(realImage==null){
            println("real image is loading...")
            realImage = RealImage(fileName)
        }
        realImage?.display()
    }
}

/**
 *
 *     fun main() {
 *
 *    // Loading Image Using Proxy class
 *    val imageUrl = "chatGptImage.png"
 *    val proxyImage = ProxyImage(imageUrl)
 *    // first create an object and then loading it
 *    proxyImage.display()
 *    // image cashed in proxy and loading immediately
 *    proxyImage.display()
 *
 *
 *    }


 */