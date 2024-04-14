package dev.ivan_belyaev.film_by_id.data

import dev.ivan_belyaev.film_by_id.data.dto.film_info.FilmByIdDto
import dev.ivan_belyaev.film_by_id.data.dto.film_posters.FilmPostersDto
import dev.ivan_belyaev.film_by_id.data.dto.film_reviews.FilmReviewsDto
import dev.ivan_belyaev.network.okhttp.ApiSetting
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("/v1.4/review")
    suspend fun requestReviews(
        @Header(ApiSetting.header) token: String,
        @Query("movieId") id: String
    ): FilmReviewsDto
}
