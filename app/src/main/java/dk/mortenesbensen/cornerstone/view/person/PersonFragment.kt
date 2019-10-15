package dk.mortenesbensen.cornerstone.view.person

import androidx.databinding.ObservableField
import dk.mortenesbensen.androidcornerstone.view.BaseFragment
import dk.mortenesbensen.cornerstone.R
import dk.mortenesbensen.cornerstone.model.Person
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.android.inject

@FlowPreview
class PersonFragment : BaseFragment() {

    override val bindingLayoutRes: Int = R.layout.person_fragment

    val viewModel : PersonViewModel by inject()

    val person = ObservableField<Person>()

    init {
        viewModel.state.observe {
            when(it) {
                PersonViewModel.ViewModelState.Loading -> TODO()
                is PersonViewModel.ViewModelState.Loaded -> TODO()
                PersonViewModel.ViewModelState.Error -> TODO()
            }
        }
    }

    fun findPersonClicked() {

    }
}