package app.chenqi

/**
 * Keep consistent with android.utl.log constant level.
 * */
enum class Level(val value: Int) {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7)
}

expect object Log {
    fun isLoggable(tag: String, level: Level): Boolean
    fun v(tag: String, msg: String)
    fun d(tag: String, msg: String)
    fun i(tag: String, msg: String)
    fun w(tag: String, msg: String)
    fun e(tag: String, msg: String)
    fun wtf(tag: String, msg: String)
}