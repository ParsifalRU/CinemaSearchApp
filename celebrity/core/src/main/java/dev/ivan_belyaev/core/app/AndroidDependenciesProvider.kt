package dev.ivan_belyaev.core.app

import android.app.Application
import android.content.Context

interface AndroidDependenciesProvider {

    fun provideApplication(): Application

    fun provideContext(): Context
}