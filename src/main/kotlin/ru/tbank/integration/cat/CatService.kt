package ru.tbank.integration.cat

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.annotation.Single
import ru.tbank.config.PropertyConfig
import ru.tbank.model.CatFact

@Single
class CatService(
    private val propertyConfig: PropertyConfig
) {
    private val catHttpClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(propertyConfig.fetchProperty("integration.cat-fact.host"))
        }
    }

    suspend fun findAny(): CatFact {
        return catHttpClient.get("fact")
            .body<CatFactResponseDto>()
            .let { CatFact(fact = it.fact, length = it.length) }
    }
}
