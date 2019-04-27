package app.chenqi

actual object Log {
    actual fun v(tag: String, msg: String){}
    actual fun d(tag: String, msg: String){}
    actual fun i(tag: String, msg: String){}
    actual fun w(tag: String, msg: String){}
    actual fun e(tag: String, msg: String){}
}
