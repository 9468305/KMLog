package app.chenqi

actual object Log {
    actual var level = Level.INFO
    actual fun isLoggable(tag: String, level: Level): Boolean = android.util.Log.isLoggable(tag, level.number)
    actual fun v(tag: String, msg: String) { android.util.Log.v(tag, msg) }
    actual fun d(tag: String, msg: String) { android.util.Log.d(tag, msg) }
    actual fun i(tag: String, msg: String) { android.util.Log.i(tag, msg) }
    actual fun w(tag: String, msg: String) { android.util.Log.w(tag, msg) }
    actual fun e(tag: String, msg: String) { android.util.Log.e(tag, msg) }
    actual fun wtf(tag: String, msg: String) { android.util.Log.wtf(tag, msg) }
}
