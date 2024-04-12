package dev.ivan_belyaev.all_films_api.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.all_films_api.presentation.viewmodel.AllFilmsViewModel
import dev.ivan_belyaev.core.base.di.ViewModelKey

@Module
interface AllFilmsViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AllFilmsViewModel::class)
    fun provideAllFilmsViewModel(viewModel: AllFilmsViewModel): ViewModel
}