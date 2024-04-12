package dev.ivan_belyaev.cinemasearchapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.cinemasearchapp.MainActivityViewModel
import dev.ivan_belyaev.core.base.di.ViewModelKey

@Module
internal interface MainActivityViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}