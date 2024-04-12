package dev.ivan_belyaev.film_by_id.data.dto.film_info

import com.google.gson.annotations.SerializedName

data class FilmByIdDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("year")
    val year: Int,
    @SerializedName("names")
    val names: List<NamesModel>,
    @SerializedName("description")
    val description: String?,
    @SerializedName("rating")
    val rating: RatingModel,
    @SerializedName("votes")
    val votes: VotesModel,
    @SerializedName("poster")
    val poster: PosterModel,
    @SerializedName("teaser")
    val teaser: TeaserModel,
)