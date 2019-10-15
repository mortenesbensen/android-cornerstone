package dk.mortenesbensen.androidcornerstone.util

import android.util.Log

fun Any.log(message: String) {
    Log.d(this.classNameOrValue(), message)
}

fun Any.classNameOrValue(): String {
    return this as? String ?: this::class.java.simpleName
}
