package ru.tbank.integration.dog

import kotlinx.serialization.Serializable

@Serializable
data class DogFactResponseDto(
    val data: List<DogFactData>,
)

@Serializable
data class DogFactData(
    val id: String,
    val type: String,
    val attributes: DogFactAttributes
)

@Serializable
data class DogFactAttributes(
    val body: String,
)
