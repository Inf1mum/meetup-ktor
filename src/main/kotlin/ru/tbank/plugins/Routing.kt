package ru.tbank.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.tbank.entity.User

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/user") {
            call.respond(User("Vadim", "Lazuk", "vadim.lazuk@mail.ru"))
        }
    }
}
