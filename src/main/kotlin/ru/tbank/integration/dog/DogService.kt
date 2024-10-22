package ru.tbank.integration.dog

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.annotation.Single
import ru.tbank.config.PropertyConfig
import ru.tbank.model.DogFact

@Single
class DogService(
    private val propertyConfig: PropertyConfig
) {
    private val dogHttpClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(propertyConfig.fetchProperty("integration.dog-fact.host"))
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    suspend fun findAny(): DogFact {
        return dogHttpClient.get("facts")
            .body<DogFactResponseDto>()
            .let { DogFact(fact = it.data.first().attributes.body, id = it.data.first().id) }
    }
}
