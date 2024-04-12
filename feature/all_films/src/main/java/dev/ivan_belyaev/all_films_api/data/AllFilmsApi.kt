package dev.ivan_belyaev.all_films_api.data

import androidx.annotation.IntRange
import dev.ivan_belyaev.all_films_api.data.dto.film_by_name.FilmByNameDto
import dev.ivan_belyaev.all_films_api.data.dto.films_with_filters.FilmsWithFiltersDto
import dev.ivan_belyaev.network.okhttp.ApiSetting
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AllFilmsApi {

    @GET("/v1.4/movie/search")
    suspend fun fetchFilmByName(
        @Header(ApiSetting.header) token: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("query") query: String
    ): FilmByNameDto

    @GET("/v1.4/movie")
    suspend fun fetchFilmsWithFilters(
        @Header(ApiSetting.header) token: String,
        @Query("page") @IntRange(from = 1) page: Int = 1,
        @Query("limit") @IntRange(from = 0, to = 10) limit: Int = 10,
        @Query("selectFields") selectFields: Array<String> = arrayOf("id", "names"),
        @Query("ageRating") ageRating: Array<String>? = null,
        @Query("countries.name") countriesName: Array<String>? = null,
        @Query("premiere.cinema") premiereCinema: Array<String>? = null,
    ): FilmsWithFiltersDto

}