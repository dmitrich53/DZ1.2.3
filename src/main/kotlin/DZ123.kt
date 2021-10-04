fun main() {
    val trackPrice = 100

    class Melo(var num: String, var name: String, var rating: String, var cash: Int) {
        override fun toString(): String {
            return "$num$name $rating  сумма всех покупок  $cash рублей."
        }
    }
    println("В клубе любителей музыки:")
    val melomans = arrayOf(
        Melo("1.   ", "Антон", "любитель", 1000),
        Melo("2.   ", "Семён", "любитель", 1001),
        Melo("3.   ", "Анна", "меломан", 10001)
    )
    melomans.forEach { println(it) }

    while (true) {
        println("Добрый день! Кто готов совершить покупки? Введите свой номер.")
        println("Или введите q для выхода")
        val input = readLine()
        if (input == "q") {
            println("Итог последних приобретений.")
            melomans.forEach { println(it) }
            break
        }
        val userNumber = input?.toInt()?.minus(1)

        println("Добрый день " + melomans[userNumber!!].name + "! Cколько композиций Вы хотите приобрести?")
        val count = readLine()?.toInt()
        var summ = count?.times(trackPrice)
        if (summ!! >= 10_001) {
            summ = summ / 100 * 95
            println(" Ваша скидка 5%")
            println("Сумма к оплате $summ")
            if (melomans[userNumber].rating == "меломан") println(" Cкидка 1% за меломанство ")
            summ = summ / 100 * 99
            println("Сумма к оплате $summ")
            melomans[userNumber].cash = summ

        } else if (summ >= 1_001) {
            summ -= 100
            println(" Ваша скидка 100р")
            println("Сумма к оплате $summ")
            if (melomans[userNumber].rating == "меломан") println(" Cкидка 1% за меломанство")
            summ = summ / 100 * 99
            println("Сумма к оплате $summ")
            melomans[userNumber].cash = summ
        } else if (melomans[userNumber].rating == "меломан") {
            summ = summ / 100 * 99
            println(" Cкидка 1% за меломанство")
            println("Сумма к оплате $summ")
            melomans[userNumber].cash = summ
        } else {
            println(" Скидки нет.")
            println("Сумма к оплате $summ")
            melomans[userNumber].cash = summ
        }
    }
}
