package dev.ivan_belyaev.film_by_id.data

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

object ApiSetting {
    const val header = "X-API-KEY"
    const val token = "WF76VQQ-HQB4P5G-JFJH8DF-CRKDP1M"
}

interface FilmByIdApi {

    @GET("/v1.4/movie/{id}")
    suspend fun requestFilmById(
        @Header(ApiSetting.header) token: String,
        @Path("id") id: Int
    ): Response
}