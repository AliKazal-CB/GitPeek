package com.example.gitpeek.network.model

import com.google.gson.annotations.SerializedName

/**
 * A data transfer object class for {User}
 */
data class UserDto(
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @SerializedName("name")
    val name: String? = null,
)