package org.bitcoindevkit.kmp

import org.bitcoindevkit.Auth
import org.bitcoindevkit.ElectrumConfig
import org.bitcoindevkit.Network
import org.bitcoindevkit.RpcSyncParams

expect class AddressInfo(index: UInt, address: String) {
    var index: UInt
    var address: String
}

expect class Address(address: String) {
    fun scriptPubkey(): Script
}

expect class Script(rawOutputScript: List<UByte>)

expect class ElectrumConfig {
    var url: String
    var socks5: String?
    var retry: UByte
    var timeout: UByte?
    var stopGap: ULong
    var validateDomain: Boolean
}

expect class EsploraConfig {
    var baseUrl: String
    var proxy: String?
    var concurrency: UByte?
    var stopGap: ULong
    var timeout: ULong?
}

expect class RpcConfig {
    var url: String
    var auth: Auth
    var network: Network
    var walletName: String
    var syncParams: RpcSyncParams?
}

expect class Blockchain(config: BlockchainConfig) {
    fun broadcast(transaction: Transaction)
    fun getBlockHash(height: UInt): String
    fun getHeight(): UInt
}

sealed class BlockchainConfig {
    data class Electrum(val config: ElectrumConfig): BlockchainConfig()
    data class Esplora(val config: EsploraConfig): BlockchainConfig()
    data class Rpc(val config: RpcConfig): BlockchainConfig()
}

expect class PartiallySignedTransaction(psbtBase64: String) {
    fun combine(other: PartiallySignedTransaction): org.bitcoindevkit.PartiallySignedTransaction
    fun extractTx(): Transaction
    fun serialize(): String
    fun txid(): String
}
