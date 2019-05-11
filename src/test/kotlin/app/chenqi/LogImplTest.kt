package app.chenqi

import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.Test
import kotlin.test.assertFalse

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class LogImplTest: LogTest() {
    override val tag = "Android"

    @Test
    override fun testIsLoggable() { super.testIsLoggable() }

    @Test
    override fun testLog() { super.testLog() }
}