package app.chenqi

import kotlin.test.Test

class LogImplTests {
    @Test
    fun testLog() {
        LogImpl.d("Android", "d")
    }
}