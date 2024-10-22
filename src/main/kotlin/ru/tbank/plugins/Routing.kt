package ru.tbank.plugins

import io.ktor.server.application.*
import ru.tbank.route.animal.animalRoutes
import ru.tbank.route.user.userRoutes

fun Application.configureRouting() {
    userRoutes()
    animalRoutes()
}
