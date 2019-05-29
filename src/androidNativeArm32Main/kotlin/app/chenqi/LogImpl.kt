package app.chenqi

import platform.android.*

@kotlin.ExperimentalUnsignedTypes
actual object Log {
    actual fun isLoggable(tag: String, level: Level): Boolean  = level >= Level.INFO
    actual fun v(tag: String, msg: String) {__android_log_print(ANDROID_LOG_VERBOSE.toInt(), tag, "%s", msg)}
    actual fun d(tag: String, msg: String) {__android_log_print(ANDROID_LOG_DEBUG.toInt(), tag, "%s", msg)}
    actual fun i(tag: String, msg: String) { __android_log_print(ANDROID_LOG_INFO.toInt(), tag, "%s", msg)}
    actual fun w(tag: String, msg: String) {__android_log_print(ANDROID_LOG_WARN.toInt(), tag, "%s", msg)}
    actual fun e(tag: String, msg: String) {__android_log_print(ANDROID_LOG_ERROR.toInt(), tag, "%s", msg)}
    actual fun wtf(tag: String, msg: String) { __android_log_print(ANDROID_LOG_FATAL.toInt(), tag, "%s", msg)}
}
