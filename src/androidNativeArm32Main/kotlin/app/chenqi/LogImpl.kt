package app.chenqi

import platform.android.*

actual object Log {
    actual fun isLoggable(tag: String, level: Level): Boolean  = level >= Level.INFO
    actual fun v(tag: String, msg: String) {__android_log_print(ANDROID_LOG_VERBOSE.toInt(), "Tag", "%s", "msg")}
    actual fun d(tag: String, msg: String) {__android_log_print(ANDROID_LOG_DEBUG.toInt(), "Tag", "%s", "msg")}
    actual fun i(tag: String, msg: String) { __android_log_print(ANDROID_LOG_INFO.toInt(), "Tag", "%s", "msg")}
    actual fun w(tag: String, msg: String) {__android_log_print(ANDROID_LOG_WARN.toInt(), "Tag", "%s", "msg")}
    actual fun e(tag: String, msg: String) {__android_log_print(ANDROID_LOG_ERROR.toInt(), "Tag", "%s", "msg")}
    actual fun wtf(tag: String, msg: String) { __android_log_print(ANDROID_LOG_FATAL.toInt(), "Tag", "%s", "msg")}
}
