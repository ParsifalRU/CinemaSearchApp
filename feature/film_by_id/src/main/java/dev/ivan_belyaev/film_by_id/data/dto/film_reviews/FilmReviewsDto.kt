package dev.ivan_belyaev.film_by_id.data.dto.film_reviews

data class FilmReviewsDto(
    val docs: List<FilmReviewsInfoModel>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int,
)