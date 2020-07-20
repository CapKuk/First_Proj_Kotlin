import java.lang.Exception
import java.lang.NullPointerException

fun main() {
    print("Введите город, в котором вы живете: ")
    val city = readLine() ?: "NSK"
    print("Какая у вас погода? ")
    val message = when(readLine()?.toIntOrNull() ?: 0){
        in -50..15 -> "холодно"
        in 15..25 -> "норм"
        in 25..50 -> "жарко"
        else -> "катастрофа"
    }
    print("В городе $city сейчас $message")
}




