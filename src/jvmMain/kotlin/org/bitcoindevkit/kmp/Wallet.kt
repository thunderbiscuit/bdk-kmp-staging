package org.bitcoindevkit.kmp

actual class Wallet actual constructor(
    descriptor: Descriptor,
    changeDescriptor: Descriptor?,
    network: Network,
    databaseConfig: DatabaseConfig
) {
    // internal delegates for Wallet and DatabaseConfig
    private val internalDatabaseConfig: org.bitcoindevkit.DatabaseConfig = when (databaseConfig) {
        is DatabaseConfig.Memory -> org.bitcoindevkit.DatabaseConfig.Memory
        is DatabaseConfig.Sled   -> org.bitcoindevkit.DatabaseConfig.Sled(databaseConfig.config)
        is DatabaseConfig.Sqlite -> org.bitcoindevkit.DatabaseConfig.Sqlite(databaseConfig.config)
    }
    private val wallet: org.bitcoindevkit.Wallet = org.bitcoindevkit.Wallet(
        descriptor = descriptor,
        changeDescriptor = changeDescriptor,
        network = network,
        databaseConfig = internalDatabaseConfig
    )

    actual fun getAddress(addressIndex: AddressIndex): AddressInfo {
        val internalAddressIndex: org.bitcoindevkit.AddressIndex = when (addressIndex) {
            is AddressIndex.New        -> org.bitcoindevkit.AddressIndex.New
            is AddressIndex.LastUnused -> org.bitcoindevkit.AddressIndex.LastUnused
            is AddressIndex.Peek       -> org.bitcoindevkit.AddressIndex.Peek(addressIndex.index)
            is AddressIndex.Reset      -> org.bitcoindevkit.AddressIndex.Reset(addressIndex.index)
        }
        return wallet.getAddress(internalAddressIndex)
    }

    actual fun getInternalAddress(addressIndex: AddressIndex): AddressInfo {
        val internalAddressIndex: org.bitcoindevkit.AddressIndex = when (addressIndex) {
            is AddressIndex.New        -> org.bitcoindevkit.AddressIndex.New
            is AddressIndex.LastUnused -> org.bitcoindevkit.AddressIndex.LastUnused
            is AddressIndex.Peek       -> org.bitcoindevkit.AddressIndex.Peek(addressIndex.index)
            is AddressIndex.Reset      -> org.bitcoindevkit.AddressIndex.Reset(addressIndex.index)
        }
        return wallet.getInternalAddress(internalAddressIndex)
    }

    actual fun getBalance(): Balance {
        return wallet.getBalance()
    }

    actual fun sign(psbt: PartiallySignedTransaction): Boolean {
        return wallet.sign(psbt)
    }

    actual fun listTransactions(): List<TransactionDetails> {
        return wallet.listTransactions()
    }

    actual fun network(): Network {
        return wallet.network()
    }

    // actual fun sync(blockchain: Blockchain, progress: Progress?) {}

    // actual fun listUnspent(): List<LocalUtxo> {
    //     return listOf()
    // }
}

