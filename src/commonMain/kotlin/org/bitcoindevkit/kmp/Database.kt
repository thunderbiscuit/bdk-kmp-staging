package org.bitcoindevkit.kmp

sealed class DatabaseConfig {
    object Memory: DatabaseConfig()
    data class Sled(val config: SledDbConfiguration): DatabaseConfig()
    data class Sqlite(val config: SqliteDbConfiguration): DatabaseConfig()
}

expect object Memory

expect class SledDbConfiguration {
    var path: String
    var treeName: String
}

expect class SqliteDbConfiguration {
    var path: String
}
