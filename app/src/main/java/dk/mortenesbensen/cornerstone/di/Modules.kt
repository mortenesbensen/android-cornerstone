package dk.mortenesbensen.cornerstone.di

import dk.mortenesbensen.cornerstone.repository.FakeDelayedPersonRepository
import dk.mortenesbensen.cornerstone.repository.PersonRepository
import dk.mortenesbensen.cornerstone.view.person.PersonViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val module: Module = module {

    // View models
    viewModel { PersonViewModel(get()) }

    // Repositories
    single<PersonRepository> { FakeDelayedPersonRepository() }
}