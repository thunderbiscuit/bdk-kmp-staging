package org.example.kmpcalculator

import kotlin.test.Test
import kotlin.test.assertEquals

class BasicTest {
    @Test
    fun testHello() {
        assertEquals(
            "Hello from everyone!",
            hello()
        )
    }

    @Test
    fun testGoodBye() {
        assertEquals(
            "Goodbye from JVM!",
            goodBye()
        )
    }
}
