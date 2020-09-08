import org.junit.Test

import org.junit.Assert.*


class MainKtTest {

    @Test
    fun getFee_from_VkPay_to_VkPay_upToLimits() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1_500_000L

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
        val transfer = 1_500_001L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_VkPay_to_VkPay_monthLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 4_000_000L
        val transfer = 1L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_Card_to_VkPay_upToLimits() {
        val from = FinServices.VISA
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 15_000_000L

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
        val transfer = 15_000_001L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_Card_to_VkPay_monthLimitOverrun() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 60_000_000L
        val transfer = 1L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_upToLimits_min() {
        val from = FinServices.VISA
        val to = FinServices.MAESTRO
        val monthTransfers = 0L
        val transfer = 466_666L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(3500, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_upToLimits_075() {
        val from = FinServices.MIR
        val to = FinServices.MASTER_CARD
        val monthTransfers = 0L
        val transfer = 466_667L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(3501, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_transferLimitOverrun() {
        val from = FinServices.VISA
        val to = FinServices.MIR
        val monthTransfers = 0L
        val transfer = 15_000_001L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_Visa_Mir_to_Card_monthLimitOverrun() {
        val from = FinServices.MIR
        val to = FinServices.VISA
        val monthTransfers = 60_000_000L
        val transfer = 1L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_Mastercard_Maestro_to_Card_upToLimits() {
        val from = FinServices.MASTER_CARD
        val to = FinServices.VISA
        val monthTransfers = 0L
        val transfer = 15_000_000L

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
        val from = FinServices.MAESTRO
        val to = FinServices.MIR
        val monthTransfers = 0L
        val transfer = 15_000_001L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }

    @Test
    fun getFee_from_Mastercard_Maestro_to_Card_monthLimitOverrun() {
        val from = FinServices.MASTER_CARD
        val to = FinServices.VISA
        val monthTransfers = 60_000_000L
        val transfer = 1L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(-1, result)
    }
}