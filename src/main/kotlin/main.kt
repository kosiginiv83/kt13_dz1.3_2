import kotlin.math.ceil


fun main() {
    print("1) ")
    println(getFee(from = FinServices.VK_PAY, transfer = 1_000_000))
    print("2) ")
    println(getFee(from = FinServices.VK_PAY, transfer = 1_500_001))
    print("3) ")
    println(getFee(from = FinServices.VK_PAY, transfer = 1, monthTransfers = 4_000_000))
    print("4) ")
    println(getFee(from = FinServices.VISA, transfer = 15_000_001))
    print("5) ")
    println(getFee(from = FinServices.MASTER_CARD, transfer = 1_000_000, monthTransfers = 1000))
    print("6) ")
    println(getFee(from = FinServices.MIR, to = FinServices.MAESTRO, transfer = 5_000_000))
    print("7) ")
    println(getFee(from = FinServices.MIR, to = FinServices.MAESTRO, transfer = 466_666))
    print("8) ")
    println(getFee(from = FinServices.MIR, to = FinServices.MAESTRO, transfer = 466_667))
}


enum class FinServices { MASTER_CARD, MAESTRO, VISA, MIR, VK_PAY }


fun getFee(from: FinServices, to: FinServices = FinServices.VK_PAY,
           monthTransfers: Long = 0, transfer: Long): Long {
    // Допущения:
    // 1) Лимиты на перевод (monthTransfer) учитываются для отправителя, для получателя - нет;
    // 2) По картам нет суточного лимита, есть только разовый и месячный;
    // 3) Комиссия не вычитается при проверке лимитов.

    val fee1 = 0.75

    when (from) {
        FinServices.VK_PAY -> {
            if (transfer > 1_500_000) {
                println("Превышен лимит перевода c Vk Pay. Максимальный размер перевода: 15 000 р")
                return -1
            }
            if (monthTransfers + transfer > 4_000_000) {
                println("Превышен лимит по сумме переводов в месяц c Vk Pay. Лимит в месяц: 40 000 р")
                return -1
            }
        }
        FinServices.VISA, FinServices.MASTER_CARD, FinServices.MAESTRO, FinServices.MIR -> {
            if (transfer > 15_000_000) {
                println("Превышен лимит перевода по карте. Максимальный размер перевода: 150 000 р")
                return -1
            }
            if (monthTransfers + transfer > 60_000_000) {
                println("Превышен лимит по сумме переводов в месяц по карте. Лимит в месяц: 600 000 р")
                return -1
            }
        }
        else -> {
            println("Недопустимая операция")
            return -1
        }
    }

    if (to == FinServices.VK_PAY) {
        return 0
    }
    return when (from) {
        FinServices.MASTER_CARD, FinServices.MAESTRO -> 0
        FinServices.VISA, FinServices.MIR ->
            if (transfer > 466_666) ceil(transfer * fee1 / 100).toLong() else 3500
        else -> {
            println("Недопустимая операция")
            -1
        }
    }
}