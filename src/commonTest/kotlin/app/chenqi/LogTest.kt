package app.chenqi

import kotlin.test.Test

class LogTest {
    private val skip =
        """
            Unit Test skipped here.
            Because When it run at Android, Log's function will call android.util.log,
            and when it run at iOS, Log's function will call NSLog.
            Both need be mocked here, make this much more complicated.
            It will be done by import pure kotlin mock library.
        """.trimIndent()

    @Test
    fun testLog() {
        println(skip)
    }

}