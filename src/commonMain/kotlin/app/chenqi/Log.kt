package app.chenqi

enum class Level(val number: Int) {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7)
}

expect object Log {
    var level: Level
    fun isLoggable(tag: String, level: Level): Boolean
    fun v(tag: String, msg: String)
    fun d(tag: String, msg: String)
    fun i(tag: String, msg: String)
    fun w(tag: String, msg: String)
    fun e(tag: String, msg: String)
    fun wtf(tag: String, msg: String)
}