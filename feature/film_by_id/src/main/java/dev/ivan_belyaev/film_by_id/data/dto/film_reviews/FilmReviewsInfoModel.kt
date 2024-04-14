package dev.ivan_belyaev.film_by_id.data.dto.film_reviews

data class FilmReviewsInfoModel(
    val id : Int,
    val movieId : Int,
    val title : String,
    val type : String,
    val review : String,
    val date : String,
    val author: String
)
