package app.chenqi

import platform.android.*

@kotlin.ExperimentalUnsignedTypes
actual object Log {
    actual fun isLoggable(tag: String, level: Level): Boolean  = level >= Level.INFO

    actual fun v(tag: String, msg: String) {
        __android_log_write(ANDROID_LOG_VERBOSE.toInt(), tag, msg)
    }
    actual fun d(tag: String, msg: String) {
        __android_log_write(ANDROID_LOG_DEBUG.toInt(), tag,  msg)
    }
    actual fun i(tag: String, msg: String) {
        __android_log_write(ANDROID_LOG_INFO.toInt(), tag, msg)
    }
    actual fun w(tag: String, msg: String) {
        __android_log_write(ANDROID_LOG_WARN.toInt(), tag, msg)
    }
    actual fun e(tag: String, msg: String) {
        __android_log_write(ANDROID_LOG_ERROR.toInt(), tag, msg)
    }
    actual fun wtf(tag: String, msg: String) {
        __android_log_write(ANDROID_LOG_FATAL.toInt(), tag, msg)
    }
}
