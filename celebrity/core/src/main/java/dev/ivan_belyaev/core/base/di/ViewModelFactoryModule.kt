package dev.ivan_belyaev.core.base.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}