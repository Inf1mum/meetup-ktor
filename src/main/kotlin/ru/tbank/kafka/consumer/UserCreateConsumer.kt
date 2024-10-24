package ru.tbank.kafka.consumer

import io.ktor.server.application.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.koin.ktor.ext.inject
import ru.tbank.config.PropertyConfig
import java.time.Duration


fun Application.startConsume() = launch(Dispatchers.IO) {
    val kafkaConsumer by inject<KafkaConsumer<String, String>>()
    val propertyConfig by inject<PropertyConfig>()
    val userCreateTopicName = propertyConfig.fetchProperty("kafka.topics.user-create.name")
    log.info("start listen topic '$userCreateTopicName'")

    kafkaConsumer.subscribe(listOf(userCreateTopicName))
    while (true) {
        val records = kafkaConsumer.poll(Duration.ofSeconds(5))
        for (record in records) {
            log.info(record.value())
        }
    }
}
