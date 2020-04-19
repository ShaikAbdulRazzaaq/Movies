package com.assignment.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recycler: RecyclerView? = null
    var list:List<Movies>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerView)
        recycler?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler?.adapter = list?.let { RecyclerAdapter(this, it) }
    }
}
