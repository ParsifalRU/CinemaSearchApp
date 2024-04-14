package dev.ivan_belyaev.film_by_id.di

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.film_by_id.data.FilmByIdRepositoryImpl
import dev.ivan_belyaev.film_by_id.data.FilmPostersRepositoryImpl
import dev.ivan_belyaev.film_by_id.data.FilmReviewsRepositoryImpl
import dev.ivan_belyaev.film_by_id.domain.FilmByIdRepository
import dev.ivan_belyaev.film_by_id.domain.FilmPostersRepository
import dev.ivan_belyaev.film_by_id.domain.FilmReviewsRepository

@Module
interface FilmByIdRepositoryModule {

    @Binds
    fun provideFilmByIdRepository(repository: FilmByIdRepositoryImpl): FilmByIdRepository

    @Binds
    fun provideFilmPostersRepository(repository: FilmPostersRepositoryImpl): FilmPostersRepository

    @Binds
    fun provideFilmReviewsRepository(repository: FilmReviewsRepositoryImpl): FilmReviewsRepository
}

