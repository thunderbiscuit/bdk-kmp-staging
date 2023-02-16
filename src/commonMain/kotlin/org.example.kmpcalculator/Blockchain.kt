package org.example.kmpcalculator

import org.bitcoindevkit.ElectrumConfig

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

expect class Blockchain(config: ElectrumConfig) {
    fun broadcast(psbt: PartiallySignedTransaction)
    fun getBlockHash(height: UInt): String
    fun getHeight(): UInt
}

expect class PartiallySignedTransaction(psbtBase64: String) {
    fun combine(other: PartiallySignedTransaction): PartiallySignedTransaction
    fun extractTx(): List<UByte>
    fun serialize(): String
    fun txid(): String
}
