package ru.tbank.route.animal

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ru.tbank.integration.cat.CatService
import ru.tbank.integration.dog.DogService

fun Application.animalRoutes() {
    val catService by inject<CatService>()
    val dogService by inject<DogService>()

    routing {
        get("/cat/fact") {
            call.respond(catService.findAny().let { CatFactDto(it.fact, it.length) })
        }

        get("/dog/fact") {
            call.respond(dogService.findAny().let { DogFactDto(it.id, it.fact) })
        }
    }
}
