package dev.ivan_belyaev.film_by_id.domain.model

data class FilmReviewsModel(
    val docs: List<FilmReviewInfoModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int,
)
