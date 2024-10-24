package ru.tbank

import io.ktor.server.application.*
import io.ktor.server.netty.*
import ru.tbank.kafka.consumer.startConsume
import ru.tbank.plugins.configureKoin
import ru.tbank.plugins.configureRouting
import ru.tbank.plugins.configureSerialization

fun main(args: Array<String>): Unit = EngineMain.main(args)


fun Application.module() {
    configureRouting()
    configureSerialization()
    configureKoin()
    startConsume()
}
