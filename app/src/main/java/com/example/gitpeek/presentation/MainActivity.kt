package com.example.gitpeek.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gitpeek.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * The project's main activity that hosts {RepoListFragment} and {RepoDetailFragment}
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}