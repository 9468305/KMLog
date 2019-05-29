package app.chenqi

import platform.android.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LogImplTest: LogTest() {
    override val tag = "AndroidNativeArm32"

    @Test
    override fun testIsLoggable() = super.testIsLoggable()

    @Test
    override fun testLog() = super.testLog()
}