package dev.ivan_belyaev.all_films_api.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.network.api.CinemasApi
import retrofit2.Retrofit

@Module
class AllFilmsApiModule {

    @Provides
    fun provideAllFilmsApi(retrofit: Retrofit): CinemasApi =
        retrofit.create(CinemasApi::class.java)
}
