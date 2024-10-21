package ru.tbank.plugins

import io.ktor.server.application.*
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.ktor.plugin.Koin
import org.koin.ksp.generated.*

@Module
@ComponentScan("com.example")
class Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(listOf(defaultModule))
    }
}
