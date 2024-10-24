package ru.tbank.route.user

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id : String,
    val firstName: String,
    val lastName: String,
    val email: String
)
