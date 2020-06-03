package com.assignment.movies.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.RetrofitSingleton
import com.assignment.movies.adapters.TopRatedAdapter
import com.assignment.movies.data.MainModelClass
import com.assignment.movies.data.Result
import kotlinx.android.synthetic.main.top_rated_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRated : Fragment() {
    private val apiKey = "apiKey"
    private var recyclerView: RecyclerView? = this.topRatedRecycler
    private var progressBar: ProgressBar? = this.topRatedMoviesProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.top_rated_fragment, container, false)
        recyclerView = v.findViewById(R.id.topRatedRecycler)
        progressBar = v.findViewById(R.id.topRatedMoviesProgressBar)
        progressBar?.visibility = View.VISIBLE
        val call: Call<MainModelClass?>? =
            RetrofitSingleton.instance().getTopRatedMovies(apiKey, "en", 1)
        call?.enqueue(object : Callback<MainModelClass?> {
            override fun onFailure(call: Call<MainModelClass?>, t: Throwable) {
                Log.e("TopRated", "Something is wrong" + t.message)
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                progressBar?.visibility = View.INVISIBLE
            }

            override fun onResponse(
                call: Call<MainModelClass?>,
                response: Response<MainModelClass?>
            ) {
                if (response.isSuccessful) {
                    progressBar?.visibility = View.INVISIBLE
                    val result = response.body()?.results
                    Log.e("tag", " " + response.body()?.results?.size)
                    if (result != null) {
                        initiate(result)
                    }
                }
            }
        })
        return (v)
    }

    private fun initiate(result: List<Result>) {
        recyclerView?.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        recyclerView?.adapter = context?.let { TopRatedAdapter(it, result) }
    }
}




