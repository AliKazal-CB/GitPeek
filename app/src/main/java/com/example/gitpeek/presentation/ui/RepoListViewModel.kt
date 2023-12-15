package com.example.gitpeek.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitpeek.domain.model.Repo
import com.example.gitpeek.domain.model.User
import com.example.gitpeek.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The ViewModel that's attached to {RepoListFragment}
 */
@HiltViewModel
class RepoListViewModel
@Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    val user: MutableState<User?> = mutableStateOf(null)
    val repos: MutableState<List<Repo>> = mutableStateOf(listOf())
    val query = mutableStateOf("")

    fun searchUser() {
        viewModelScope.launch {
            val userResult = repository.search(query.value)
            val reposResult = repository.getRepos(query.value)

            for (repo in reposResult) {
                userResult.forksTotal = userResult.forksTotal + repo.forks
            }

            user.value = userResult
            repos.value = reposResult
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }
}