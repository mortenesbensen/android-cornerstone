package dk.mortenesbensen.cornerstone.domain

import dk.mortenesbensen.androidcornerstone.data.Result
import dk.mortenesbensen.androidcornerstone.domain.UseCase
import dk.mortenesbensen.cornerstone.model.Person
import dk.mortenesbensen.cornerstone.repository.PersonRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@FlowPreview
class GetPersonUseCase(private val personRepository: PersonRepository) :
    UseCase<Person, GetPersonUseCase.Params>() {


    override fun execute(params: Params): Flow<Result<Person>> {
        return flow {
            val result = personRepository.getPerson(params.firstName)
            emit(result)
        }
    }

    data class Params(val firstName: String)
}