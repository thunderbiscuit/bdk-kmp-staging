package org.bitcoindevkit.kmp

expect class Wallet(
    descriptor: Descriptor,
    changeDescriptor: Descriptor?,
    network: Network,
    databaseConfig: DatabaseConfig
) {
    fun getAddress(addressIndex: AddressIndex): AddressInfo
    fun getInternalAddress(addressIndex: AddressIndex): AddressInfo
    fun getBalance(): Balance
    fun sign(psbt: PartiallySignedTransaction): Boolean
    fun listTransactions(): List<TransactionDetails>
    fun network(): Network
    // fun sync(blockchain: Blockchain, progress: Progress?)
    // fun listUnspent(): List<LocalUtxo>
}
