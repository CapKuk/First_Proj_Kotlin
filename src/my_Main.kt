import java.lang.Exception
import java.lang.NullPointerException

fun main() {
    print("Введите город, в котором вы живете: ")
    val city = readLine() ?: getCity()
    print("Какая у вас погода? ")
    val message = when(readLine()?.toIntOrNull() ?: getTemp()){
        in -50..15 -> "холодно"
        in 15..25 -> "норм"
        in 25..50 -> "жарко"
        else -> "катастрофа"
    }
    print("В городе $city сейчас $message")
}
fun getCity() : String{
    print("Введена строка с ошибкой ")
    return  readLine() ?: getCity()
}
fun getTemp() : Int{
    print("Введена строка с ошибкой ")
    return  readLine()?.toIntOrNull() ?: getTemp()
}




