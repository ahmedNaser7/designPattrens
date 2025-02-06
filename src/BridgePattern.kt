import javax.annotation.processing.Messager

// bridge -> composition
// handle problem of tight coupling
// elements
// Abstract & implementer & Refined Abstraction & concrete implementer

/**
                  +-------------------+          +-----------------------+
                  | Notification      |          | NotificationRenderer  |
                  |-------------------|          |-----------------------|
                  | - renderer        |<>------->| + render(title, msg)  |
                  | - title: String   |          +-----------------------+
                  | - message: String |                     /\
                  |-------------------|                     |
                  | + display()       |                     |
                  +-------------------+                     |
                          /\                                |
                          |                                 |
                          |                                 |
                  +-------------------+          +-----------------------+
                  | TextNotification  |          | AndroidNotification   |
                  |-------------------|          | Renderer              |
                  |                   |          |-----------------------|
                  | + display()       |          | + render(title, msg)  |
                  +-------------------+          +-----------------------+
                                                        |
                  +-------------------+                 |
                  | ImageNotification |                 |
                  |-------------------|          +-----------------------+
                  | - imageUrl: String|          | IOSNotification       |
                  |                   |          | Renderer              |
                  | + display()       |          |-----------------------|
                  +-------------------+          | + render(title, msg)  |
                                                 +-----------------------+

 * */

// Mobile App example
interface NotificationRenderer{
    fun render(title: String , message: String)
}

class AndroidNotificationRenderer:NotificationRenderer{
    override fun render(text: String, message: String) {
        println("Android Notification rendered $text ,$message")
    }
}

class IosNotificationRenderer:NotificationRenderer{
    override fun render(text: String, message: String) {
        println("Ios Notification rendered $text , $message ")
    }
}

abstract class  Notification(
    val notificationRenderer: NotificationRenderer,
    val title:String,
    val message:String
) {
    abstract fun display()
}

class ImageNotification(
    notificationRenderer: NotificationRenderer,
    title: String,
    message: String,
    val imageUrl:String
):Notification(notificationRenderer,title,message){
    override fun display() {
        notificationRenderer.render(title,"$message : $imageUrl")
    }
}

class TextNotification(
    notificationRenderer: NotificationRenderer,
    title: String,
    message: String
):Notification(notificationRenderer,title,message){
    override fun display() {
        notificationRenderer.render(title,message)
    }
}

/**
 *    fun main() {
 *
 *    // rendered
 *     val androidNotificationRenderer = AndroidNotificationRenderer()
 *     val iosNotificationRenderer = IosNotificationRenderer()
 *
 *    val androidTextNotification:Notification = TextNotification(androidNotificationRenderer , "Android Text Task","Test text 1")
 *    val iosTextNotification:Notification = TextNotification(iosNotificationRenderer , "Ios Text Task","Test text 2")
 *
 *    val androidImageNotification = ImageNotification(androidNotificationRenderer,"Android Image Task","Test image 1","image1.jpg")
 *    val iosImageNotification = ImageNotification(iosNotificationRenderer,"Ios Image Task","Test image 1","image1.jpg")
 *
 *    println("Android")
 *    androidTextNotification.display()
 *    androidImageNotification.display()
 *
 *    println("Ios")
 *    iosTextNotification.display()
 *    iosImageNotification.display()
 *
 *
 * }
 *
 *
 * */
