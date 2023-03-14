package org.bitcoindevkit.kmp

import org.bitcoindevkit.BlockTime

expect class Transaction(transactionBytes: List<UByte>) {
    fun serialize(): List<UByte>
}

expect enum class Network {
    BITCOIN,
    TESTNET,
    SIGNET,
    REGTEST,
}

sealed class AddressIndex {
    object New : AddressIndex()
    object LastUnused : AddressIndex()
    data class Peek(val index: UInt) : AddressIndex()
    data class Reset(val index: UInt) : AddressIndex()
}

expect class Peek {
    val index: UInt
}
expect class Reset {
    val index: UInt
}

expect class Balance {
    var immature: ULong
    var trustedPending: ULong
    var untrustedPending: ULong
    var confirmed: ULong
    var spendable: ULong
    var total: ULong
}

expect class TransactionDetails {
    var fee: ULong?
    var received: ULong
    var sent: ULong
    var txid: String
    var confirmationTime: BlockTime?
}
