package ru.tbank.repository

import com.mongodb.client.model.Filters.eq
import com.mongodb.kotlin.client.MongoDatabase
import io.ktor.server.plugins.*
import org.bson.types.ObjectId
import ru.tbank.entity.Identifiable
import java.util.*
import kotlin.reflect.KClass

abstract class BaseRepository<T : Identifiable>(
    mongoDatabase: MongoDatabase,
    clazz: KClass<T>
) {
    private val collection = mongoDatabase.getCollection(clazz.simpleName.orEmpty().lowercase(), clazz.java)

    fun findAll(): List<T> = collection.find().toList()

    fun findById(id: ObjectId): T? = collection.find(eq("_id", id)).firstOrNull()

    fun getById(id: ObjectId): T = findById(id) ?: throw NotFoundException()

    fun getById(id: String): T = findById(parse(id)) ?: throw NotFoundException()

    fun save(entity: T): T {
        val insertedId = collection.insertOne(entity).insertedId?.asObjectId()?.value ?: throw NotFoundException()
        return getById(insertedId)
    }

    private fun parse(id: String): ObjectId {
        return if (ObjectId.isValid(id)) ObjectId(id) else ObjectId(Date())
    }

}
