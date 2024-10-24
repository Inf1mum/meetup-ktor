package ru.tbank.kafka.event

import kotlinx.serialization.Serializable

@Serializable
data class UserCreateEvent(
    val id : String,
    val firstName: String,
    val lastName: String,
    val email: String
)
