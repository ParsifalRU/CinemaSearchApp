package dev.ivan_belyaev.film_by_id.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.core.base.di.ViewModelKey
import dev.ivan_belyaev.film_by_id.presentation.viewmodel.FilmByIdViewModel

@Module
interface FilmByIdViewModelsModule  {

    @Binds
    @IntoMap
    @ViewModelKey(FilmByIdViewModel::class)
    fun providePinCreateViewModel(viewModel: FilmByIdViewModel): ViewModel
}