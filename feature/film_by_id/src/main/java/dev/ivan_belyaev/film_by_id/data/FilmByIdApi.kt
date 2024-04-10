package dev.ivan_belyaev.film_by_id.data

import dev.ivan_belyaev.film_by_id.data.dto.film_info.FilmByIdDto
import dev.ivan_belyaev.film_by_id.data.dto.film_posters.FilmPostersDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

object ApiSetting {
    const val header = "X-API-KEY"
    const val token = "WF76VQQ-HQB4P5G-JFJH8DF-CRKDP1M"
}

interface FilmByIdApi {

    @GET("/v1.4/movie/{id}")
    suspend fun requestFilmById(
        @Header(ApiSetting.header) token: String,
        @Path("id") id: Int
    ): FilmByIdDto

    @GET("/v1.4/image")
    suspend fun requestPosters(
        @Header(ApiSetting.header) token: String,
        @Query("movieId") id: Int
    ): FilmPostersDto
}
