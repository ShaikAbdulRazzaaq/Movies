package com.assignment.movies

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var recycler: RecyclerView? = null
    private var progressbar: ProgressBar? = null
    private var floatingActionButton: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerView)
        progressbar = findViewById(R.id.progress)
        floatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton?.setOnClickListener {
            showProgressBar()
        }

    }

    private fun showProgressBar() {
        progressbar?.visibility= View.VISIBLE
    }
}
