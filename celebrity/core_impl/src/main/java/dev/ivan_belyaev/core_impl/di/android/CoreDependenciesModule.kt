package dev.ivan_belyaev.core_impl.di.android

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.core.resources.AppResources
import dev.ivan_belyaev.core.wrapper.SharedPreferencesWrapper
import dev.ivan_belyaev.core_impl.resources.AppResourcesImpl
import dev.ivan_belyaev.core_impl.wrapperimpl.SharedPreferencesWrapperImpl

@Module
interface CoreDependenciesModule {

    @Binds
    fun bindAppResources(appResources: AppResourcesImpl): AppResources

    @Binds
    fun bindSharedPreferencesWrapper(
        sharedPreferencesWrapperImpl: SharedPreferencesWrapperImpl
    ): SharedPreferencesWrapper

}