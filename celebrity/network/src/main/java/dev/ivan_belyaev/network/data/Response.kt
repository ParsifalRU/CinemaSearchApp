package dev.ivan_belyaev.network.data

data class Response(
    val statusCode: Int,
    val message: String,
    val error: String
)
