package dev.ivan_belyaev.film_by_id.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.network.api.CinemasApi
import retrofit2.Retrofit

@Module
class FilmByIdApiModule {

    @Provides
    fun provideFilmByIdApi(retrofit: Retrofit): CinemasApi =
        retrofit.create(CinemasApi::class.java)
}