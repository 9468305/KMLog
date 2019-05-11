package app.chenqi

import java.util.logging.Level
import java.util.logging.Logger

actual object Log {
    private val logger = Logger.getLogger("jvmTest")

    actual var level: app.chenqi.Level
        get() = when (logger.level) {
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
        set(value) {
            when (value) {
                app.chenqi.Level.VERBOSE -> Level.FINER
                app.chenqi.Level.DEBUG -> Level.FINE
                app.chenqi.Level.INFO -> Level.CONFIG
                app.chenqi.Level.WARN -> Level.INFO
                app.chenqi.Level.ERROR -> Level.WARNING
                app.chenqi.Level.ASSERT -> Level.SEVERE
            }
        }

    actual fun isLoggable(tag: String, level: app.chenqi.Level): Boolean = level >= this.level

    actual fun v(tag: String, msg: String) = logger.finest("$tag | $msg")
    actual fun d(tag: String, msg: String) = logger.fine("$tag | $msg")
    actual fun i(tag: String, msg: String) = logger.info("$tag | $msg")
    actual fun w(tag: String, msg: String) = logger.warning("$tag | $msg")
    actual fun e(tag: String, msg: String) = logger.severe("$tag | $msg")
    actual fun wtf(tag: String, msg: String) = logger.severe("$tag | $msg")
}
