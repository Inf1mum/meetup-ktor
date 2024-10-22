package ru.tbank.route.animal

import kotlinx.serialization.Serializable

@Serializable
data class CatFactDto(
    val fact: String,
    val length: Int
)
