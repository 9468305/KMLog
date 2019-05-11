package app.chenqi

import kotlin.test.Test

class LogImplTest: LogTest() {
    override val tag = "JVM"

    @Test
    override fun testIsLoggable() = super.testIsLoggable()

    @Test
    override fun testLog() = super.testLog()
}