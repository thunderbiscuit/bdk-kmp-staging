package org.example.kmpcalculator

import kotlin.test.Test
import kotlin.test.assertEquals

class BlockchainTest {
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
        val blockchain = Blockchain(electrumConfig)
        println("The block height is ${blockchain.getHeight()}")
    }

    @Test
    fun testAddressInfo() {
        val addressInfo = AddressInfo(0u, "tb1qk5238eluqllq2wps67lkxme3x43wll4k282s8q")
        assertEquals(0u, addressInfo.index)
        assertEquals("tb1qk5238eluqllq2wps67lkxme3x43wll4k282s8q", addressInfo.address)
    }

    @Test
    fun testAddress() {
        val address: Address = Address("tb1qk5238eluqllq2wps67lkxme3x43wll4k282s8q")
    }
}
