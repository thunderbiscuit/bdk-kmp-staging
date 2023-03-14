package org.bitcoindevkit.kmp

import kotlin.test.Test
import kotlin.test.assertEquals

class BlockchainTest {
    @Test
    fun testBlockchain() {
        val electrumConfig = BlockchainConfig.Electrum(
            ElectrumConfig(
                url = "ssl://electrum.blockstream.info:60002",
                socks5 = null,
                retry = 3u,
                timeout = null,
                stopGap = 20uL,
                validateDomain = true
            )
        )
        val esploraConfig = BlockchainConfig.Esplora(
            EsploraConfig(
                baseUrl = "https://blockstream.info/testnet/api",
                proxy = null,
                concurrency = null,
                stopGap = 20uL,
                timeout = null
            )
        )
        val electrumBlockchain = Blockchain(electrumConfig)
        val esploraBlockchain = Blockchain(esploraConfig)
        println("The testnet block height according to electrum is ${electrumBlockchain.getHeight()}")
        println("The testnet block height according to esplora is ${esploraBlockchain.getHeight()}")
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
