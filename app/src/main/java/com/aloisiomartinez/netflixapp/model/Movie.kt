package com.aloisiomartinez.netflixapp.model

import androidx.annotation.DrawableRes

data class Movie(
    val id: Int, val coverUrl: String,
    val title: String = "",
    val desc: String = "",
    val cast: String = ""
)