package dev.ivan_belyaev.film_by_id.domain.model

data class FilmReviewInfoModel(
    val id : Int,
    val movieId : Int,
    val title : String,
    val type : String,
    val review : String,
    val author: String,
    val date : String,
)
