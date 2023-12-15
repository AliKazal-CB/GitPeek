package com.example.gitpeek.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A parcelable data class for git user repo
 */
@Parcelize
data class Repo(
    val name: String? = null,
    val description: String? = null,
    val updatedAt: String? = null,
    val stargazersCount: Int = 0,
    val forks: Int = 0
) : Parcelable