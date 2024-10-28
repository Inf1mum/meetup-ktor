package ru.tbank.service

import org.koin.core.annotation.Single
import ru.tbank.entity.User
import ru.tbank.kafka.producer.UserCreateProducer
import ru.tbank.repository.UserRepository


@Single
class UserService(
    private val userRepository: UserRepository,
    private val userCreateProducer: UserCreateProducer
) {
    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun getById(id: String): User {
        return userRepository.getById(id)
    }

    fun save(user: User): User {
        return userRepository.save(user).also {
            userCreateProducer.produce(it)
        }
    }
}
