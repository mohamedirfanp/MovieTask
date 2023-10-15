package com.example.movietask.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movietask.viewmodels.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchItem: String, movieViewModel: MovieViewModel, onSearch: (String) -> Unit) {
    LaunchedEffect(key1 = movieViewModel.currentPage, block = {
        movieViewModel.getMovieList(searchItem)
    })
    Column(Modifier.padding(30.dp)) {

//        Row() {
            OutlinedTextField(
                value = searchItem,
                onValueChange = { updatedSearchItem ->
                    onSearch(updatedSearchItem) // Notify the parent composable of the updated search item
                },
                placeholder = { Text("search movie") }
            )
//            IconButton(onClick = {
//                movieViewModel.getMovieList(searchItem, 1)
//            }) {
////                Icon(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "search")
//
//            }
            Button(onClick = {
                movieViewModel.getMovieList(searchItem)
            }) {
                Text(text = "Search")
            }

    }
}
