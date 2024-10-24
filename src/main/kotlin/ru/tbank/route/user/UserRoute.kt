package ru.tbank.route.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ru.tbank.entity.User
import ru.tbank.service.UserService

fun Application.userRoutes() {
    val userService by inject<UserService>()

    routing {
        get("/users") {
            call.respond(userService.findAll().map { toUserDto(it) })
        }

        get("/users/{id}") {
            val id = call.parameters["id"].orEmpty()
            call.respond(toUserDto(userService.findById(id)))
        }

        post("/users") {
            val user = call.receive<UserCreateDto>().let { User(
                id = null,
                firstName = it.firstName,
                lastName = it.lastName,
                email = it.email
            ) }
            call.respond(toUserDto(userService.save(user)))
        }
    }
}

fun toUserDto(user: User) = UserDto(user.id.toString(), user.firstName, user.lastName, user.email)
