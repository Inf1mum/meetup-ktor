package ru.tbank.kafka.producer

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.koin.core.annotation.Single
import ru.tbank.config.PropertyConfig
import ru.tbank.entity.User
import ru.tbank.kafka.event.UserCreateEvent

@Single
class UserCreateProducer(
    private val kafkaProducer: KafkaProducer<String, String>,
    propertyConfig: PropertyConfig
) {
    private val userCreateTopicName = propertyConfig.fetchProperty("kafka.topics.user-create.name")

    fun produce(user: User) {
        kafkaProducer.send(ProducerRecord(
            userCreateTopicName,
            Json.encodeToString(UserCreateEvent(user.id.toString(), user.firstName, user.lastName, user.email))
        ))
    }
}
