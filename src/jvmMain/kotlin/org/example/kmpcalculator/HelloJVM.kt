package org.example.kmpcalculator

import org.bitcoindevkit.AddressInfo
import org.bitcoindevkit.Blockchain
import org.bitcoindevkit.BlockchainConfig
import org.bitcoindevkit.ElectrumConfig

actual fun platformGoodBye(): String {
    return "Goodbye from JVM!"
}

actual typealias AddressInfoKMP = AddressInfo
actual typealias AddressKMP = org.bitcoindevkit.Address
actual typealias Script = org.bitcoindevkit.Script
actual typealias PartiallySignedTransaction = org.bitcoindevkit.PartiallySignedTransaction
actual typealias ElectrumConfig = org.bitcoindevkit.ElectrumConfig

actual class BlockchainKMP actual constructor(config: ElectrumConfig){
    val blockchain = Blockchain(BlockchainConfig.Electrum(config))

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

// actual class AddressInfo actual constructor(index: UInt, address: String): BdkAddressInfo(index, address)
//     actual val index: UInt = index
//     actual val address: String
// }


// actual interface AddressInfo: AddressInfo {
//     actual val index: UInt
//     actual val address: String
// }
