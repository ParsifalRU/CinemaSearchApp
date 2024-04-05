package dev.ivan_belyaev.core.app

import dev.ivan_belyaev.core.resources.AppResources

interface CoreDependenciesProvider :
    AndroidDependenciesProvider {

    fun provideAppResources(): AppResources
}