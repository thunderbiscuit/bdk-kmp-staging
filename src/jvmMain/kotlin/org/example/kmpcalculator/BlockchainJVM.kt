package org.example.kmpcalculator

import org.bitcoindevkit.AddressInfo
import org.bitcoindevkit.Blockchain as BlockchainBDK
import org.bitcoindevkit.BlockchainConfig

actual typealias AddressInfo = AddressInfo
actual typealias Address = org.bitcoindevkit.Address
actual typealias Script = org.bitcoindevkit.Script
actual typealias PartiallySignedTransaction = org.bitcoindevkit.PartiallySignedTransaction
actual typealias ElectrumConfig = org.bitcoindevkit.ElectrumConfig

actual class Blockchain actual constructor(config: ElectrumConfig){
    val blockchain = BlockchainBDK(BlockchainConfig.Electrum(config))

    actual fun broadcast(psbt: PartiallySignedTransaction) {
        blockchain.broadcast(psbt)
    }

    actual fun getBlockHash(height: UInt): String {
        return blockchain.getBlockHash(height)
    }

    actual fun getHeight(): UInt {
        return blockchain.getHeight()
    }
}
