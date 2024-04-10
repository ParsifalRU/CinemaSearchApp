package dev.ivan_belyaev.film_by_id.presentation.model

data class PostersFilmsUiModel(
    val docs: List<PosterFilmsInfoUiModel>
)

data class PosterFilmsInfoUiModel(
    val url: String,
    val id: String
)