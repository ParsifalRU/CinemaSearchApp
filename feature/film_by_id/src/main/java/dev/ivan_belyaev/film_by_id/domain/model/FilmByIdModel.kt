package dev.ivan_belyaev.film_by_id.domain.model

import com.google.gson.annotations.SerializedName
import dev.ivan_belyaev.film_by_id.data.dto.film_info.PosterModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.RatingModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.VotesModel

data class FilmByIdModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("rating")
    val rating: RatingModel,
    @SerializedName("votes")
    val votes: VotesModel,
    @SerializedName("poster")
    val poster: PosterModel,
)