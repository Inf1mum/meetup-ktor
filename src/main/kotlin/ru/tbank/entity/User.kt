package ru.tbank.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.kotlinx.ObjectIdSerializer
import org.bson.types.ObjectId

@Serializable
data class User(
    @Serializable(with = ObjectIdSerializer::class)
    @SerialName("_id")
    override var id : ObjectId?,
    val firstName: String,
    val lastName: String,
    val email: String
) : Identifiable
