package ru.tbank.route.user

import kotlinx.serialization.Serializable

@Serializable
class UserCreateDto(
    val firstName: String,
    val lastName: String,
    val email: String
)
