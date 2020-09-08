import org.junit.Test

import org.junit.Assert.*


class MainKtTest {

    @Test
    fun getFee_from_VkPay_to_VkPay_upToLimits() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_VkPay_to_VkPay_transferLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_VkPay_to_VkPay_monthLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Card_to_VkPay_upToLimits() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Card_to_VkPay_transferLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Card_to_VkPay_monthLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_upToLimits() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_transferLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_monthLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Mastercard_Maestro_to_Card_upToLimits() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Mastercard_Maestro_to_Card_transferLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }

    @Test
    fun getFee_from_Mastercard_Maestro_to_Card_monthLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }
}