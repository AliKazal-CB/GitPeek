package com.example.gitpeek.network.model

import com.google.gson.annotations.SerializedName

/**
 * A data transfer object class for {Repo}
 */
data class RepoDto(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("updatedAt")
    val updatedAt: String? = null,

    @SerializedName("stargazersCount")
    val stargazersCount: Int = 0,

    @SerializedName("forks")
    val forks: Int = 0
)