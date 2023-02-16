package org.example.kmpcalculator

// hello() and platformHello() are defined at the "common" level and will be the same for all platforms
fun hello(): String {
    return platformHello()
}
fun platformHello(): String {
    return "Hello from everyone!"
}

// goodBye() and platformGoodBye() are defined at the platform level and will be different for each platform
fun goodBye(): String {
    return platformGoodBye()
}
expect fun platformGoodBye(): String
