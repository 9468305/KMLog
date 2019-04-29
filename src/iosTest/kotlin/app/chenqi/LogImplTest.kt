package app.chenqi

import kotlin.test.Test

class LogImplTest {
    private val tag = "iOS"

    @Test
    fun testLogV() {
        Log.v(tag, "Verbose")
    }

    @Test
    fun testLogD() {
        Log.d(tag, "Debug")
    }

    @Test
    fun testLogI() {
        Log.i(tag, "Info")
    }

    @Test
    fun testLogW() {
        Log.w(tag, "Warn")
    }

    @Test
    fun testLogE() {
        Log.e(tag, "Error")
    }
}