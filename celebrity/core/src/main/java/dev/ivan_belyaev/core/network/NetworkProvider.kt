package dev.ivan_belyaev.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface NetworkProvider {

    fun provideRetrofitVideoService(): Retrofit

    fun provideOkHttpClient(): OkHttpClient
}