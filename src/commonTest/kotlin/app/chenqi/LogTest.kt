package app.chenqi

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit Test skipped.
 * Because It will running for all target platform, and call all target platform's implementation.
 * When it run at Android, Log's function will call android.util.log,
 * When it run at iOS, Log's function will call print and NSLog.
 * When it run at JVM, log's function will call java.util.logger.
 * All platform implementation need be mocked, which make commonTest much more complicated.
 * Only pure kotlin code should be tested in commonTest, by pure kotlin mock framework.
 * */
open class LogTest {

    open val tag = "commonTest"

    open fun testIsLoggable() {
        assertFalse(Log.isLoggable(tag, Level.VERBOSE))
        assertFalse(Log.isLoggable(tag, Level.DEBUG))
        assertTrue(Log.isLoggable(tag, Level.INFO))
        assertTrue(Log.isLoggable(tag, Level.WARN))
        assertTrue(Log.isLoggable(tag, Level.ERROR))
        assertTrue(Log.isLoggable(tag, Level.ASSERT))
    }

    open fun testLog() {
        Log.v(tag, "Verbose")
        Log.d(tag, "Debug")
        Log.i(tag, "Info")
        Log.w(tag, "Warn")
        Log.e(tag, "Error")
        Log.wtf(tag, "Assert")
    }

    @Test
    fun skip() = println("Skip")

}