package com.example.gitpeek.di

import com.example.gitpeek.network.UserService
import com.example.gitpeek.network.model.RepoDtoMapper
import com.example.gitpeek.network.model.UserDtoMapper
import com.example.gitpeek.repository.UserRepository
import com.example.gitpeek.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The Retrofit instance is injecting into the repository and
 * the {RepositoryModule} is injected into {RepoListViewModel}
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(
        userService: UserService, userDtoMapper: UserDtoMapper, repoDtoMapper: RepoDtoMapper
    ): UserRepository {
        return UserRepositoryImpl(
            userService = userService, userMapper = userDtoMapper, repoMapper = repoDtoMapper
        )
    }
}