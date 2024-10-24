package ru.tbank.plugins

import io.ktor.server.application.*
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.ksp.generated.module
import org.koin.ktor.plugin.Koin
import ru.tbank.config.KafkaConfig
import ru.tbank.config.MongoConfig

@Module
@ComponentScan("ru.tbank")
class Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(listOf(Koin().module, MongoConfig().module, KafkaConfig().module))
    }
}
