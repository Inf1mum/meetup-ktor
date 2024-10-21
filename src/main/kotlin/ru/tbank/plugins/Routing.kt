package ru.tbank.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ru.tbank.config.PropertyConfig
import ru.tbank.entity.User
import ru.tbank.service.UserService

fun Application.configureRouting() {
    val userService by inject<UserService>()
    val propertyConfig by inject<PropertyConfig>()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/user") {
            call.respond(User("Vadim", "Lazuk", "vadim.lazuk@mail.ru"))
        }

        get("/user/db") {
            call.respond(userService.findAll())
        }

        get("/user/hello") {
            call.respond(propertyConfig.fetchProperty("app.message").orEmpty())
        }
    }
}
