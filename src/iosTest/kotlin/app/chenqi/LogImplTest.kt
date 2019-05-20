package app.chenqi

import platform.darwin.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LogImplTest: LogTest() {
    override val tag = "iOS"

    @Test
    override fun testIsLoggable() {
        println(Log.isLoggable(tag, Level.VERBOSE))
        println(Log.isLoggable(tag, Level.DEBUG))
        println(Log.isLoggable(tag, Level.INFO))
        println(Log.isLoggable(tag, Level.WARN))
        println(Log.isLoggable(tag, Level.ERROR))
        println(Log.isLoggable(tag, Level.ASSERT))
    }

    @Test
    override fun testLog() = super.testLog()
}