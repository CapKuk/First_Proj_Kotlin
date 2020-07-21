fun main() {
    print("Введите город, в котором вы живете: ")
    val city = getCity()
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
    val city = readLine()
    if(city == null || city == "")
    {
        print("Введена строка с ошибкой. Город должен иметь название. Введите еще раз: ")
        return getCity()
    }
    return city
}
fun getTemp() : Int{
    print("Введена строка с ошибкой. Погода должна записываться числом. ")
    return  readLine()?.toIntOrNull() ?: getTemp()
}




