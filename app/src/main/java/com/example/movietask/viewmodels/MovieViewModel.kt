package com.example.movietask.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietask.constants.API_KEY
import com.example.movietask.models.SearchResponse
import com.example.movietask.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var movieListResponse:SearchResponse by mutableStateOf(SearchResponse("", emptyList(), ""))

    var errorMessage: String by mutableStateOf("")

    var currentPage : Int by mutableStateOf(1)

    fun getMovieList(searchItem : String) {
        viewModelScope.launch {

            val apiService = ApiService.getInstance()
            try {
                if(searchItem != "")
                    movieListResponse = apiService.searchMovies(searchItem, API_KEY, currentPage)
//                Log.d("JSON", movieListResponse.toString())
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }
}