package app.chenqi

actual object LogImpl {
    actual fun v(tag: String, msg: String): Int = android.util.Log.v(tag, msg)
    actual fun d(tag: String, msg: String): Int = android.util.Log.d(tag, msg)
    actual fun i(tag: String, msg: String): Int = android.util.Log.i(tag, msg)
    actual fun w(tag: String, msg: String): Int = android.util.Log.w(tag, msg)
    actual fun e(tag: String, msg: String): Int = android.util.Log.e(tag, msg)
}
