package dev.ivan_belyaev.film_by_id.presentation.adapter.film_reviews

data class ReviewsModel (
    val id : Int,
    val movieId : Int,
    val title : String,
    val author: String,
    val type : String,
    val review : String,
    val date : String,
)