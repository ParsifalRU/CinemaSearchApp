package dev.ivan_belyaev.core_impl.di.android

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.core.resources.AppResources
import dev.ivan_belyaev.core_impl.resources.AppResourcesImpl

@Module
interface CoreDependenciesModule {

    @Binds
    fun bindAppResources(appResources: AppResourcesImpl): AppResources

}