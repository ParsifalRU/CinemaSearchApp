package dev.ivan_belyaev.all_films_api.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.all_films_api.data.AllFilmsApi
import retrofit2.Retrofit

@Module
class AllFilmsApiModule {

    @Provides
    fun provideAllFilmsApi(retrofit: Retrofit): AllFilmsApi =
        retrofit.create(AllFilmsApi::class.java)
}
