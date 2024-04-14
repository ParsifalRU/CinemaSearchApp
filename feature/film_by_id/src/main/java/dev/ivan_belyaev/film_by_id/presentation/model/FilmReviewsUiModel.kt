package dev.ivan_belyaev.film_by_id.presentation.model

data class FilmReviewsUiModel (
    val docs: List<ReviewsFilmsInfoUiModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int,
)

data class ReviewsFilmsInfoUiModel(
    val id : Int,
    val movieId : Int,
    val title : String,
    val type : String,
    val review : String,
    val date : String,
    val author: String
)