package org.example.kmpcalculator

public fun hello(): String {
    return platformHello()
}

fun platformHello(): String {
    return "Hello from everyone!"
}

public fun goodBye(): String {
    return platformGoodBye()
}

expect fun platformGoodBye(): String

expect class AddressInfoKMP(index: UInt, address: String) {
    public var index: UInt
    public var address: String
}

expect class AddressKMP(address: String) {
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

interface BlockchainKMP {
    fun broadcast(psbt: PartiallySignedTransaction)
    fun getBlockHash(height: UInt): String
    fun getHeight(): UInt
}

expect class BlockchainKMP2(config: ElectrumConfig): BlockchainKMP

expect class PartiallySignedTransaction(psbtBase64: String) {
    fun combine(other: PartiallySignedTransaction): PartiallySignedTransaction
    fun extractTx(): List<UByte>
    fun serialize(): String
    fun txid(): String
}
