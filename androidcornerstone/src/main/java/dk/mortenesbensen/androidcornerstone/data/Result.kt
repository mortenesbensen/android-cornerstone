package dk.mortenesbensen.androidcornerstone.data

sealed class Result<out Value> {

    data class Success<Value>(val value: Value) : Result<Value>()
    object Error : Result<Nothing>()

}