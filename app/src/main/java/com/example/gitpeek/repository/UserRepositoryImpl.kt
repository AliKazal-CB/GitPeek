package com.example.gitpeek.repository

import com.example.gitpeek.domain.model.Repo
import com.example.gitpeek.domain.model.User
import com.example.gitpeek.network.UserService
import com.example.gitpeek.network.model.RepoDtoMapper
import com.example.gitpeek.network.model.UserDtoMapper

/**
 * An implementation of {UserRepository} interface
 */
class UserRepositoryImpl(
    private val userService: UserService,
    private val userMapper: UserDtoMapper,
    private val repoMapper: RepoDtoMapper
) : UserRepository {
    override suspend fun search(username: String): User {
        return userMapper.mapToDomainModel(userService.search(username))
    }

    override suspend fun getRepos(username: String): List<Repo> {
        return repoMapper.toDomainList(userService.getRepos(username))
    }
}