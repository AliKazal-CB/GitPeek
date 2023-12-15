package com.example.gitpeek.network.model

import com.example.gitpeek.domain.model.Repo
import com.example.gitpeek.domain.util.DomainMapper

/**
 * A data transfer object class responsible for mapping to and from {Repo}
 */
class RepoDtoMapper : DomainMapper<RepoDto, Repo> {
    override fun mapToDomainModel(model: RepoDto): Repo {
        return Repo(
            name = model.name,
            description = model.description,
            updatedAt = model.updatedAt,
            stargazersCount = model.stargazersCount,
            forks = model.forks
        )
    }

    override fun mapFromDomainModel(domainModel: Repo): RepoDto {
        return RepoDto(
            name = domainModel.name,
            description = domainModel.description,
            updatedAt = domainModel.updatedAt,
            stargazersCount = domainModel.stargazersCount,
            forks = domainModel.forks
        )
    }

    fun toDomainList(initial: List<RepoDto>): List<Repo> {
        return initial.map { mapToDomainModel(it) }
    }
}