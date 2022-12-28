package com.aloisiomartinez.netflixapp

import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.helper.widget.Layer
import androidx.core.content.ContextCompat

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val toolbar: Toolbar = findViewById(R.id.movie_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // get drawable (layer-list)
        val layerDrawable: LayerDrawable = ContextCompat.getDrawable(this, R.drawable.shadows) as LayerDrawable
        //get movie
        val movieCover = ContextCompat.getDrawable(this, R.drawable.movie_4)
        //set layer-list to movie
        layerDrawable.setDrawableByLayerId(R.id.cover_drawable, movieCover)
        //set imageVIew
        val coverImg: ImageView = findViewById(R.id.movie_img)
        coverImg.setImageDrawable(layerDrawable)

    }
}