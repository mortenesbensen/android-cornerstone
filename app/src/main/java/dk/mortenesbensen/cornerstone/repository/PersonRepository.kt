package dk.mortenesbensen.cornerstone.repository

import dk.mortenesbensen.androidcornerstone.data.Result
import dk.mortenesbensen.cornerstone.model.Person

interface PersonRepository {

   suspend fun getPerson(firstName : String) : Result<Person>

}