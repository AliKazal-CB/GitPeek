package com.example.gitpeek.repository

import com.example.gitpeek.domain.model.Repo
import com.example.gitpeek.domain.model.User

/**
 * An interface of the retrofit network functions
 */
interface UserRepository {
    suspend fun search(username: String): User
    suspend fun getRepos(username: String): List<Repo>
}