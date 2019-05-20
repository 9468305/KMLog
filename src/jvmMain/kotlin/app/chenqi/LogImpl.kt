package app.chenqi

import java.util.logging.Level
import java.util.logging.Logger

private fun app.chenqi.Level.fromPlatform(level: Level): app.chenqi.Level =
    when (level) {
        Level.FINEST -> app.chenqi.Level.VERBOSE
        Level.FINER -> app.chenqi.Level.VERBOSE
        Level.FINE -> app.chenqi.Level.DEBUG
        Level.CONFIG -> app.chenqi.Level.INFO
        Level.INFO -> app.chenqi.Level.WARN
        Level.WARNING -> app.chenqi.Level.ERROR
        Level.SEVERE -> app.chenqi.Level.ASSERT
        else -> {
            app.chenqi.Level.INFO
        }
    }

private fun app.chenqi.Level.toPlatform(): Level =
    when (this) {
        app.chenqi.Level.VERBOSE -> Level.FINEST
        app.chenqi.Level.DEBUG -> Level.CONFIG
        app.chenqi.Level.INFO -> Level.INFO
        app.chenqi.Level.WARN -> Level.INFO
        app.chenqi.Level.ERROR -> Level.WARNING
        app.chenqi.Level.ASSERT -> Level.SEVERE
    }

actual object Log {
    private val logger = Logger.getLogger("jvmTest")

    actual fun isLoggable(tag: String, level: app.chenqi.Level): Boolean = logger.isLoggable(level.toPlatform())
    actual fun v(tag: String, msg: String) = logger.finest("$tag | $msg")
    actual fun d(tag: String, msg: String) = logger.fine("$tag | $msg")
    actual fun i(tag: String, msg: String) = logger.info("$tag | $msg")
    actual fun w(tag: String, msg: String) = logger.warning("$tag | $msg")
    actual fun e(tag: String, msg: String) = logger.severe("$tag | $msg")
    actual fun wtf(tag: String, msg: String) = logger.severe("$tag | $msg")
}
