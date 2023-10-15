package com.example.movietask.models

data class SearchResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)