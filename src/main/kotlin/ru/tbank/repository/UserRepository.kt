package ru.tbank.repository

import org.koin.core.annotation.Single
import ru.tbank.entity.User

@Single
class UserRepository {
    fun findAll(): List<User> {
        return listOf(User("Ivan", "Petrov", "ivan.petrov@mail.ru"))
    }
}
