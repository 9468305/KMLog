package app.chenqi

import java.util.logging.*
import java.util.logging.Level

actual object Log {
    private val logger = Logger.getLogger("jvmTest").apply { level = Level.ALL }

    actual fun v(tag: String, msg: String) = logger.finest("$tag | $msg")
    actual fun d(tag: String, msg: String) = logger.fine("$tag | $msg")
    actual fun i(tag: String, msg: String) = logger.info("$tag | $msg")
    actual fun w(tag: String, msg: String) = logger.warning("$tag | $msg")
    actual fun e(tag: String, msg: String) = logger.severe("$tag | $msg")
}
