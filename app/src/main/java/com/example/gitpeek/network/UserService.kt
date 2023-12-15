package com.example.gitpeek.network

import com.example.gitpeek.network.model.RepoDto
import com.example.gitpeek.network.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * An interface for the implementing Retrofit network calls
 */
interface UserService {
    @GET("{username}")
    suspend fun search(
        @Path("username") username: String
    ): UserDto

    @GET("{username}/repos")
    suspend fun getRepos(
        @Path("username") username: String
    ): List<RepoDto>
}