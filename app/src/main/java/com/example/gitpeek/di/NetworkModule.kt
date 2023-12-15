package com.example.gitpeek.di

import com.example.gitpeek.network.UserService
import com.example.gitpeek.network.model.RepoDtoMapper
import com.example.gitpeek.network.model.UserDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * A Hilt dependency Singleton object called {NetworkModule}
 * based on the dependencies in the Network package
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideUserMapper(): UserDtoMapper {
        return UserDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRepoMapper(): RepoDtoMapper {
        return RepoDtoMapper()
    }

    @Singleton
    @Provides
    fun provideUserService(): UserService {
        return Retrofit.Builder().baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(UserService::class.java)
    }
}