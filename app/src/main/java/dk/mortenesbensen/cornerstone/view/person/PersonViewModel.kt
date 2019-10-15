package dk.mortenesbensen.cornerstone.view.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.mortenesbensen.androidcornerstone.data.Result
import dk.mortenesbensen.cornerstone.domain.GetPersonUseCase
import dk.mortenesbensen.cornerstone.model.Person
import dk.mortenesbensen.cornerstone.repository.PersonRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@FlowPreview
class PersonViewModel(private val personRepository: PersonRepository) : ViewModel() {

    val state: LiveData<ViewModelState>
        get() = viewModelState
    private val viewModelState = MutableLiveData<ViewModelState>()

    fun getPerson(firstName: String) {

        viewModelState.value = ViewModelState.Loading

        viewModelScope.launch {
            val getPersonUseCase = GetPersonUseCase(personRepository)

            getPersonUseCase(GetPersonUseCase.Params(firstName)).collect {
                viewModelState.value = when (it) {
                    is Result.Success -> ViewModelState.Loaded(it.value)
                    Result.Error -> ViewModelState.Error
                }
            }
        }
    }

    sealed class ViewModelState {
        object Loading : ViewModelState()
        data class Loaded(val person: Person) : ViewModelState()
        object Error : ViewModelState()
    }
}