package dev.ivan_belyaev.network.api

import dev.ivan_belyaev.network.data.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

object ApiSetting {
    const val header = "X-API-KEY"
    const val token = "WF76VQQ-HQB4P5G-JFJH8DF-CRKDP1M"
}

interface CinemasApi {

    @GET("v1.4/movie/{id}")
    fun requestFilmById(
        @Header(ApiSetting.header) token: String,
        @Path("id") id: Int
    ): Response
}