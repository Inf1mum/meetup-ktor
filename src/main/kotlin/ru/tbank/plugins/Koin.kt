package ru.tbank.plugins

import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import ru.tbank.repository.UserRepository

fun Application.configureKoin() {
    install(Koin) {
        //slf4jLogger()
        modules(listOf(appModule))
    }
}

val appModule = module {
    single { UserRepository() }
}
