package dev.ivan_belyaev.film_by_id.data.dto.film_posters

data class FilmPostersDto(
    val docs: List<FilmInfoModel>,
    val page: Int,
    val pages: Int
)
