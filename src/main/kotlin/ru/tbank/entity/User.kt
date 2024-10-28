package ru.tbank.entity

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class User(
    @Contextual
    @SerialName("_id")
    override var id : ObjectId? = null,
    val firstName: String,
    val lastName: String,
    val email: String
) : Identifiable
