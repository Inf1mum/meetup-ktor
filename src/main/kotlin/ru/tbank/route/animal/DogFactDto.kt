package ru.tbank.route.animal

import kotlinx.serialization.Serializable

@Serializable
data class DogFactDto(
    val id: String,
    val fact: String
)
