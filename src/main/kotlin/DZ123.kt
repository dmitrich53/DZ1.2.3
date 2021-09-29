fun main() {
    val trackPrice: Int = 100
    val startDiscount1: Int = 1_001
    val startDiscount2: Int = 10_001
    val startDiscount3 = "меломан"


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
        var vvod = readLine()
        if (vvod == "q") {
            println("Итог последних приобретений.")
            melomans.forEach { println(it) }
            break
        }
        var vvod1 = vvod?.toInt()

        vvod1 = vvod1?.minus(1)

        println("Добрый день " + melomans[vvod1!!].name + "! Cколько композиций Вы хотите приобрести?")
        var count1 = readLine()
        var count = count1?.toInt()
        var summ = count?.times(trackPrice)
        if (summ!! >= startDiscount2) {
            summ = summ / 100 * 95
            println(" Ваша скидка 5%")
            println("Сумма к оплате $summ")
            if (melomans[vvod1].rating == startDiscount3) println(" Cкидка 1% за меломанство ")
            summ = summ / 100 * 99
            println("Сумма к оплате $summ")
            melomans[vvod1!!].cash = summ

        } else if (summ >= startDiscount1) {
            summ -= 100
            println(" Ваша скидка 100р")
            println("Сумма к оплате $summ")
            if (melomans[vvod1].rating == startDiscount3) println(" Cкидка 1% за меломанство")
            summ = summ / 100 * 99
            println("Сумма к оплате $summ")
            melomans[vvod1].cash = summ
        } else if (melomans[vvod1].rating == startDiscount3) {
            summ = summ / 100 * 99
            println(" Cкидка 1% за меломанство")
            println("Сумма к оплате $summ")
            melomans[vvod1].cash = summ
        } else {
            println(" Скидки нет.")
            println("Сумма к оплате $summ")
            melomans[vvod1].cash = summ
        }
    }
}
