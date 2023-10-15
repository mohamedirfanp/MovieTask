package com.example.movietask.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movietask.components.MovieTile
import com.example.movietask.components.SearchBar
import com.example.movietask.viewmodels.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(movieViewModel: MovieViewModel) {
    var searchItem by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Movie App") }, colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.LightGray,
                titleContentColor = Color.Black
            ))
        },
        content = {
            Column(modifier = Modifier
                .padding(it)
                .fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                SearchBar(
                    searchItem = searchItem,
                    movieViewModel
                ) { query ->
                    searchItem = query
                }
                Divider()
                if(movieViewModel.movieListResponse.Response == "True")
                {
                    Text(text = "Searched Movie List", fontSize = 30.sp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp))
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row {
                        Button(onClick = {
                            if(movieViewModel.currentPage > 1)
                                movieViewModel.currentPage -= 1

                        }) {
                            Text(text = "Prev")
                        }
                        Button(onClick = {
                            movieViewModel.currentPage += 1
                        }) {
                            Text(text = "Next")
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                }
                movieViewModel.movieListResponse.Search.let {
                    LazyColumn(content = {
                        items(movieViewModel.movieListResponse.Search) {
                            MovieTile(movie = it)
                        }
                    })
                }

            }

        }

    )
}


