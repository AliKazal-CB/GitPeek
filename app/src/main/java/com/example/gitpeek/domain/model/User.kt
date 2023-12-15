package com.example.gitpeek.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A parcelable data class for git user
 */
@Parcelize
data class User(
    val avatarUrl: String? = null,
    val name: String? = null,
    var forksTotal: Int = 0
) : Parcelable