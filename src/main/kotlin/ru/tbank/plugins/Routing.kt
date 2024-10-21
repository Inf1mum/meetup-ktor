package ru.tbank.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ru.tbank.entity.User
import ru.tbank.repository.UserRepository

fun Application.configureRouting() {
    val userRepository by inject<UserRepository>()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/user") {
            call.respond(User("Vadim", "Lazuk", "vadim.lazuk@mail.ru"))
        }

        get("/user/db") {
            call.respond(userRepository.findAll())
        }
    }
}
