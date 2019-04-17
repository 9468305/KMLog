package sample

actual class Sample {
    actual fun checkMe() = 44
}

actual object Platform {
    actual fun name(): String = "Android"
}
