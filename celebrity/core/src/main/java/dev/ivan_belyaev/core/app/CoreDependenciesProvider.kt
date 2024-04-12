package dev.ivan_belyaev.core.app

import dev.ivan_belyaev.core.resources.AppResources
import dev.ivan_belyaev.core.wrapper.SharedPreferencesWrapper

interface CoreDependenciesProvider :
    AndroidDependenciesProvider {

    fun provideAppResources(): AppResources

    fun provideSharedPreferencesWrapper(): SharedPreferencesWrapper
}