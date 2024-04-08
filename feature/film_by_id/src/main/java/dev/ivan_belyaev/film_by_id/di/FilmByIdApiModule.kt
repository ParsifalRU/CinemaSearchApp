package dev.ivan_belyaev.film_by_id.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.film_by_id.data.FilmByIdApi
import retrofit2.Retrofit

@Module
class FilmByIdApiModule {

    @Provides
    fun provideFilmByIdApi(retrofit: Retrofit): FilmByIdApi =
        retrofit.create(FilmByIdApi::class.java)
}