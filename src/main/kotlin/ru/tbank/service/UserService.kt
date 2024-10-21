package ru.tbank.service

import org.koin.core.annotation.Single
import ru.tbank.entity.User
import ru.tbank.repository.UserRepository

@Single
class UserService(
    private val userRepository: UserRepository
) {
    fun findAll(): List<User> {
        return userRepository.findAll()
    }
}
