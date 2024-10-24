package ru.tbank.repository

import com.mongodb.kotlin.client.MongoDatabase
import org.koin.core.annotation.Single
import ru.tbank.entity.User

@Single
class UserRepository(
    mongoDatabase: MongoDatabase
) : BaseRepository<User>(mongoDatabase, User::class)

