package app.chenqi

import platform.Foundation.NSLog

actual object Log {
    actual fun v(tag: String, msg: String) { NSLog("V | $tag | $msg") }
    actual fun d(tag: String, msg: String) { NSLog("D | $tag | $msg") }
    actual fun i(tag: String, msg: String) { NSLog("I | $tag | $msg") }
    actual fun w(tag: String, msg: String) { NSLog("W | $tag | $msg") }
    actual fun e(tag: String, msg: String) { NSLog("E | $tag | $msg") }
}
