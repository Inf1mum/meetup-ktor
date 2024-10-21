package ru.tbank.repository

import ru.tbank.entity.User

class UserRepository {
    fun findAll(): List<User> {
        return listOf(User("Ivan", "Petrov", "ivan.petrov@mail.ru"))
    }
}
