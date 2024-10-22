package ru.tbank.integration.cat

import kotlinx.serialization.Serializable

@Serializable
data class CatFactResponseDto(
    val fact: String,
    val length: Int
)
