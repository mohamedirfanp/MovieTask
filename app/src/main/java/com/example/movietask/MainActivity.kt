package com.example.movietask


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.movietask.screens.MainScreen
import com.example.movietask.ui.theme.MovieTaskTheme
import com.example.movietask.viewmodels.MovieViewModel

//import com.guru.fontawesomecomposelib.FaIconType
//import com.guru.fontawesomecomposelib.FaIcons



class MainActivity : ComponentActivity() {
    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(movieViewModel = movieViewModel)
                }
            }
        }
    }
}


