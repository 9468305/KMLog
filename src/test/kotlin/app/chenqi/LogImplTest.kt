package app.chenqi

import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
class LogImplTest {
    @Test
    fun testLog() {
        Log.d("Android", "d")
    }
}