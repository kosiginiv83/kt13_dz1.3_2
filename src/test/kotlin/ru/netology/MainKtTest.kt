package ru.netology

import org.junit.Test

import org.junit.Assert.*


class MainKtTest {

    @Test
    fun getFee_toVK_Pay() {
        val from = FinServices.VK_PAY
        val to = FinServices.VK_PAY
        val monthTransfers = 0L
        val transfer = 1_000_000L

        val result = getFee(
            from = from,
            to = to,
            monthTransfers = monthTransfers,
            transfer = transfer
        )

        assertEquals(0, result)
    }
}