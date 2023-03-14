package org.bitcoindevkit.kmp

import kotlin.test.Test

class WalletTest {
    @Test
    fun testWallet() {
        val externalDescriptor = org.bitcoindevkit.Descriptor(
            "wpkh(tprv8ZgxMBicQKsPf2qfrEygW6fdYseJDDrVnDv26PH5BHdvSuG6ecCbHqLVof9yZcMoM31z9ur3tTYbSnr1WBqbGX97CbXcmp5H6qeMpyvx35B/84h/1h/0h/0/*)",
            Network.TESTNET
        )
        val wallet = Wallet(
            externalDescriptor,
            null,
            Network.TESTNET,
            DatabaseConfig.Memory
        )
        println("The first address of the wallet is ${wallet.getAddress(AddressIndex.New)}")
    }
}
