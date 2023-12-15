package com.example.gitpeek.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.gitpeek.R
import com.example.gitpeek.presentation.components.RepoCard
import com.example.gitpeek.presentation.components.TextInputCard
import com.example.gitpeek.presentation.components.UserDetailCard
import dagger.hilt.android.AndroidEntryPoint

/**
 * The fragment responsible for displaying the main view that has
 * the user details and their repos
 */
@AndroidEntryPoint
class RepoListFragment : Fragment() {
    private val viewModel: RepoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val user = viewModel.user.value
                val repos = viewModel.repos.value
                val query = viewModel.query.value

                Column {
                    TextInputCard(
                        inputValue = query,
                        onValueChange = { viewModel.onQueryChanged(it) },
                        onSearchClick = { viewModel.searchUser() }
                    )
                    user?.let {
                        UserDetailCard(it)
                    }

                    LazyColumn {
                        itemsIndexed(
                            items = repos
                        ) { _, repo ->
                            RepoCard(repo = repo, onClick = {
                                val bundle = Bundle()
                                bundle.putParcelable("repo", repo)
                                user?.let { bundle.putInt("forksTotal", it.forksTotal) }
                                findNavController().navigate(R.id.view_repo, bundle)
                            })
                        }
                    }
                }
            }
        }
    }
}

