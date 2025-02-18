package creationalPatterns

import javax.naming.Context

class Firebase(
    private val context: String
){
   companion object{
       private var instance:Firebase? =null
       fun getInstance(context: String):Firebase{
           if (instance==null){
               println("create new instance $context")
               instance = Firebase(context)
           }else{
               println("already instance  here $context")
           }
           return instance!!
       }
   }
}

fun main(){
    val firebase1 = Firebase.getInstance("Activity")
    println(firebase1)
    val firebase2 = Firebase.getInstance("Fragment")
    println(firebase2)

}