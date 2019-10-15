package dk.mortenesbensen.androidcornerstone.domain

import dk.mortenesbensen.androidcornerstone.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

abstract class UseCase<out T, in P> {

    abstract fun execute(params: P): Flow<Result<T>>

    @FlowPreview
    suspend operator fun invoke(
        params: P,
        dispatcher: CoroutineDispatcher = Dispatchers.Main
    ): Flow<Result<T>> {
        return withContext(dispatcher) {
            execute(params)
        }
    }
}
