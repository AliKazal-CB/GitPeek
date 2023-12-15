package com.example.gitpeek.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gitpeek.domain.model.Repo

/**
 * A Composable view for a detailed view of a selected repo
 */
@Composable
fun RepoDetailView(repo: Repo?, forksTotal: Int) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        repo?.let {
            Text(
                text = "Repo name: " + repo.name,
                style = MaterialTheme.typography.titleLarge

            )
            repo.description?.let {
                Text(
                    text = "Description: " + repo.description,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            Text(
                text = "Number of star gazers: " + repo.stargazersCount,
                style = MaterialTheme.typography.headlineMedium,
            )
        }
        Text(
            text = "Total folks in all repos: $forksTotal",
            color = if (forksTotal >= 5000) {
                Color.Red
            } else {
                Color.Black
            }
        )
    }
}