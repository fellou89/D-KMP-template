package us.fellou89.dkmptemplate.shared

expect class DebugLogger (tagString : String) {
    val tag : String
    fun log(message: String)
}