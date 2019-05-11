package app.chenqi

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLog

actual object Log {

    actual var level = Level.INFO

    private val dateFormatter = NSDateFormatter().apply { dateFormat = "yyyy-MM-dd HH:mm:ss.SSS" }

    private fun time() = dateFormatter.stringFromDate(NSDate())

    actual fun isLoggable(tag: String, level: Level): Boolean = level >= this.level
    actual fun v(tag: String, msg: String) = println("${time()} | V | $tag | $msg")
    actual fun d(tag: String, msg: String) = println("${time()} | D | $tag | $msg")
    actual fun i(tag: String, msg: String) = println("${time()} | I | $tag | $msg")
    actual fun w(tag: String, msg: String) = println("${time()} | W | $tag | $msg")
    actual fun e(tag: String, msg: String) = println("${time()} | E | $tag | $msg")
    actual fun wtf(tag: String, msg: String) = NSLog("$tag | $msg")
}
