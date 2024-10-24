package ru.tbank.config

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class KafkaConfig {
    @Single
    fun kafkaProducer(propertyConfig: PropertyConfig): KafkaProducer<String, String> {
        val producerProps = mapOf(
            "bootstrap.servers" to propertyConfig.fetchListProperty("kafka.bootstrap-servers"),
            "key.serializer" to "org.apache.kafka.common.serialization.StringSerializer",
            "value.serializer" to "org.apache.kafka.common.serialization.StringSerializer",
            "security.protocol" to "PLAINTEXT"
        )
        return KafkaProducer<String, String>(producerProps)
    }

    @Single
    fun kafkaConsumer(propertyConfig: PropertyConfig): KafkaConsumer<String, String> {
        val consumerProps =
            mapOf(
                "bootstrap.servers" to propertyConfig.fetchListProperty("kafka.bootstrap-servers"),
                "auto.offset.reset" to "earliest",
                "key.deserializer" to "org.apache.kafka.common.serialization.StringDeserializer",
                "value.deserializer" to "org.apache.kafka.common.serialization.StringDeserializer",
                "group.id" to propertyConfig.fetchProperty("kafka.topics.user-create.group-id"),
                "security.protocol" to "PLAINTEXT"
            )

        return KafkaConsumer<String, String>(consumerProps)
    }
}
