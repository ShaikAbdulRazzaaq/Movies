package com.assignment.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.assignment.movies.data.Result
import com.squareup.picasso.Picasso


class DetailedActivity : AppCompatActivity() {
    //widgets
    private lateinit var imageView: ImageView
    private lateinit var titleOfMovie: TextView
    private lateinit var dateOfMovie: TextView
    private lateinit var overView: TextView
    private lateinit var ratingPercent: TextView

    //variables


    //constants
    private val imageUrl = "https://image.tmdb.org/t/p/w500"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        imageView = findViewById(R.id.image)
        titleOfMovie = findViewById(R.id.TitleOfMovie)
        dateOfMovie = findViewById(R.id.dateOfMovie)
        overView = findViewById(R.id.OverView)
        ratingPercent = findViewById(R.id.ratingPercent)


    }


}

