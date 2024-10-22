package ru.tbank.route.user

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ru.tbank.entity.User
import ru.tbank.service.UserService

fun Application.userRoutes() {
    val userService by inject<UserService>()

    routing {
        get("/user") {
            call.respond(User("Vadim", "Lazuk", "vadim.lazuk@mail.ru"))
        }

        get("/user/db") {
            call.respond(userService.findAll())
        }
    }
}
