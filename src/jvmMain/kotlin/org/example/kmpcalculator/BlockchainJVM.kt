package org.example.kmpcalculator

import org.bitcoindevkit.AddressInfo
import org.bitcoindevkit.Blockchain as BlockchainBDK
// import org.bitcoindevkit.BlockchainConfig
import org.bitcoindevkit.FfiConverterBoolean


actual typealias AddressInfo = AddressInfo
actual typealias Address = org.bitcoindevkit.Address
actual typealias Script = org.bitcoindevkit.Script
actual typealias PartiallySignedTransaction = org.bitcoindevkit.PartiallySignedTransaction
actual typealias ElectrumConfig = org.bitcoindevkit.ElectrumConfig
actual typealias EsploraConfig = org.bitcoindevkit.EsploraConfig
actual typealias RpcConfig = org.bitcoindevkit.RpcConfig

// actual typealias Blockchain = org.bitcoindevkit.Blockchain

actual class Blockchain actual constructor(config: BlockchainConfig) {
    private val configInternal = when (config) {
        is BlockchainConfig.Electrum -> org.bitcoindevkit.BlockchainConfig.Electrum(config.config)
        is BlockchainConfig.Esplora -> org.bitcoindevkit.BlockchainConfig.Esplora(config.config)
        is BlockchainConfig.Rpc -> org.bitcoindevkit.BlockchainConfig.Rpc(config.config)
    }

    private val blockchain = org.bitcoindevkit.Blockchain(configInternal)

    actual fun broadcast(transaction: Transaction) {
        blockchain.broadcast(transaction)
    }

    actual fun getBlockHash(height: UInt): String {
        return blockchain.getBlockHash(height)
    }

    actual fun getHeight(): UInt {
        return blockchain.getHeight()
    }
}
