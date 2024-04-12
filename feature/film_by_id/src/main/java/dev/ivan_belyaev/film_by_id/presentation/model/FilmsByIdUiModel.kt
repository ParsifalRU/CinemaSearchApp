package dev.ivan_belyaev.film_by_id.presentation.model

import android.view.View
import dev.ivan_belyaev.film_by_id.data.dto.film_info.PosterModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.RatingModel
import dev.ivan_belyaev.film_by_id.data.dto.film_info.VotesModel

data class FilmsByIdUiModel (
    val name: String,
    val description: String,
    val rating: RatingModel,
    val votes: VotesModel,
    val poster: PosterModel,
    val rootLayoutVisibility: Int = View.INVISIBLE,
    val downloadLayoutVisibility: Int = View.VISIBLE
)