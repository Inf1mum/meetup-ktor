package ru.tbank.config

import com.mongodb.kotlin.client.MongoClient
import com.mongodb.kotlin.client.MongoDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class MongoConfig {
    @Single
    fun mongoDatabase(propertyConfig: PropertyConfig): MongoDatabase {
        val uri = propertyConfig.fetchProperty("mongodb.url")
        val mongoClient = MongoClient.create(uri)
        return mongoClient.getDatabase(propertyConfig.fetchProperty("mongodb.database"))
    }
}
