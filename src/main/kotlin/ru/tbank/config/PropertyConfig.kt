package ru.tbank.config

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import io.ktor.server.config.yaml.*
import org.koin.core.annotation.Single

@Single
class PropertyConfig {
    private val config by lazy {
        YamlConfig(null)
    }

    fun fetchProperty(key: String) = config?.property(key)?.getString()
}
