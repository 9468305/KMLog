package app.chenqi

expect object LogImpl {
    fun v(tag: String, msg: String): Int
    fun d(tag: String, msg: String): Int
    fun i(tag: String, msg: String): Int
    fun w(tag: String, msg: String): Int
    fun e(tag: String, msg: String): Int
}