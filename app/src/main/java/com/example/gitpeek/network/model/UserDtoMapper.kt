package com.example.gitpeek.network.model

import com.example.gitpeek.domain.model.User
import com.example.gitpeek.domain.util.DomainMapper

/**
 * A data transfer object class responsible for mapping to and from {User}
 */
class UserDtoMapper : DomainMapper<UserDto, User> {
    override fun mapToDomainModel(model: UserDto): User {
        return User(
            avatarUrl = model.avatarUrl,
            name = model.name
        )
    }

    override fun mapFromDomainModel(domainModel: User): UserDto {
        return UserDto(
            avatarUrl = domainModel.avatarUrl,
            name = domainModel.name
        )
    }
}