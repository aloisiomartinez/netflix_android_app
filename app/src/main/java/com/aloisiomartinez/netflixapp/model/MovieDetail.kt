package com.aloisiomartinez.netflixapp.model

data class MovieDetail(
    val movie: Movie,
    val similars: List<Movie>
)