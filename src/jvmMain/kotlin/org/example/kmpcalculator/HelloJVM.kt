package org.example.kmpcalculator

import org.bitcoindevkit.AddressInfo

actual fun platformGoodBye(): String {
    return "Goodbye from JVM!"
}

actual typealias AddressInfoKMP = AddressInfo
actual typealias AddressKMP = org.bitcoindevkit.Address
actual typealias Script = org.bitcoindevkit.Script
actual typealias Blockchain = org.bitcoindevkit.Blockchain
actual typealias PartiallySignedTransaction = org.bitcoindevkit.PartiallySignedTransaction
actual typealias ElectrumConfig = org.bitcoindevkit.ElectrumConfig
// actual class AddressInfo actual constructor(index: UInt, address: String): BdkAddressInfo(index, address)
//     actual val index: UInt = index
//     actual val address: String
// }


// actual interface AddressInfo: AddressInfo {
//     actual val index: UInt
//     actual val address: String
// }
