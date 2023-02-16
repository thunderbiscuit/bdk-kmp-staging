package org.example.kmpcalculator

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloJVMTest {
    @Test
    fun testHello() {
        assertEquals("Hello from everyone!", hello())
    }

    @Test
    fun testGoodBye() {
        assertEquals("Goodbye from JVM!", goodBye())
    }

    @Test
    fun testBlockchain() {
        val electrumConfig = ElectrumConfig(
            url = "ssl://electrum.blockstream.info:50002",
            socks5 = null,
            retry = 3u,
            timeout = null,
            stopGap = 20uL,
            validateDomain = true
        )
        val blockchain = BlockchainKMP2(electrumConfig)
        println("The block height is ${blockchain.getHeight()}")
    }

    @Test
    fun testAddressInfo() {
        val addressInfo = AddressInfoKMP(0u, "tb1qk5238eluqllq2wps67lkxme3x43wll4k282s8q")
        assertEquals(0u, addressInfo.index)
        assertEquals("tb1qk5238eluqllq2wps67lkxme3x43wll4k282s8q", addressInfo.address)
    }

    @Test
    fun testAddress() {
        val address: AddressKMP = AddressKMP("tb1qk5238eluqllq2wps67lkxme3x43wll4k282s8q")
    }
}
