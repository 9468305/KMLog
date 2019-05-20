package app.chenqi

import kotlinx.cinterop.UByteVarOf
import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLog
import platform.darwin.*

private fun app.chenqi.Level.fromPlatform(level: os_log_type_t): app.chenqi.Level =
    when (level) {
        OS_LOG_TYPE_DEFAULT -> app.chenqi.Level.VERBOSE
        OS_LOG_TYPE_INFO -> app.chenqi.Level.DEBUG
        OS_LOG_TYPE_DEBUG -> app.chenqi.Level.INFO
        OS_LOG_TYPE_ERROR -> app.chenqi.Level.ERROR
        OS_LOG_TYPE_FAULT -> app.chenqi.Level.ASSERT
        else -> {
            app.chenqi.Level.VERBOSE
        }
    }

private fun Level.toPlatform(): os_log_type_t =
    when (this) {
        Level.VERBOSE -> OS_LOG_TYPE_DEFAULT // 0
        Level.DEBUG -> OS_LOG_TYPE_INFO // 1
        Level.INFO -> OS_LOG_TYPE_INFO // 1
        Level.WARN -> OS_LOG_TYPE_DEBUG // 2
        Level.ERROR -> OS_LOG_TYPE_ERROR // 16
        Level.ASSERT -> OS_LOG_TYPE_FAULT // 17
    }


actual object Log {
    actual fun isLoggable(tag: String, level: Level): Boolean = os_log_type_enabled(OS_LOG_DEFAULT, level.toPlatform())
    actual fun v(tag: String, msg: String) = _os_log_internal(null, OS_LOG_DEFAULT, OS_LOG_TYPE_DEFAULT, "%{timeval}.*P | $tag | $msg")
    actual fun d(tag: String, msg: String) = _os_log_internal(null, OS_LOG_DEFAULT, OS_LOG_TYPE_DEBUG, "%{timeval}.*P | $tag | $msg")
    actual fun i(tag: String, msg: String) = _os_log_internal(null, OS_LOG_DEFAULT, OS_LOG_TYPE_INFO, "%{timeval}.*P | $tag | $msg")
    actual fun w(tag: String, msg: String) = _os_log_internal(null, OS_LOG_DEFAULT, OS_LOG_TYPE_INFO, "%{timeval}.*P | $tag | $msg")
    actual fun e(tag: String, msg: String) = _os_log_internal(null, OS_LOG_DEFAULT, OS_LOG_TYPE_ERROR, "%{timeval}.*P | $tag | $msg")
    actual fun wtf(tag: String, msg: String) = _os_log_internal(null, OS_LOG_DEFAULT, OS_LOG_TYPE_FAULT, "%{timeval}.*P | $tag | $msg")
}
