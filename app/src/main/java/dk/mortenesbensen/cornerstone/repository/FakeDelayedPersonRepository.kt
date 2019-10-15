package dk.mortenesbensen.cornerstone.repository

import dk.mortenesbensen.androidcornerstone.data.Result
import dk.mortenesbensen.cornerstone.model.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FakeDelayedPersonRepository : PersonRepository {

    private val persons = listOf(
        Person("Peter", "Parker"),
        Person("Clark", "Kent")
    )

    override suspend fun getPerson(firstName: String): Result<Person> =
        suspendCoroutine { continuation ->
            CoroutineScope(continuation.context).launch {
                delay(500L)
                val result = persons.firstOrNull { it.firstName == firstName }?.let {
                    Result.Success(it)
                } ?: Result.Error
                continuation.resume(result)
            }
        }
}