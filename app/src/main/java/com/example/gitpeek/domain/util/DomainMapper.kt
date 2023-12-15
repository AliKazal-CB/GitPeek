package com.example.gitpeek.domain.util

/**
 * An interface responsible for implementation of the mapping functions
 */
interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}