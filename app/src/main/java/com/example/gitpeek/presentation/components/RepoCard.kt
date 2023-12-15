package com.example.gitpeek.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gitpeek.domain.model.Repo

/**
 * A Composable view for a single row of repo
 */
@Composable
fun RepoCard(
    repo: Repo,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.extraSmall,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            Modifier.padding(10.dp)
        ) {
            repo.name?.let {
                Text(
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.titleMedium,
                    text = it
                )
            }

            Text(
                modifier = Modifier.padding(5.dp),
                text = repo.description ?: ""
            )
        }
    }
}