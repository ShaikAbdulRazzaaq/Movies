package com.assignment.movies.fragments

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
import kotlinx.android.synthetic.main.upcoming_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Upcoming : Fragment() {
    private val API_KEY = "73884879dfa3d28cc666c9b18d79c862"
    private var recyclerView: RecyclerView? = this.topRatedRecycler
    private var progressBar: ProgressBar? = this.upComingMoviesProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = (inflater.inflate(R.layout.upcoming_fragment, container, false))
        progressBar=v.findViewById(R.id.upComingMoviesProgressBar)
        recyclerView=v.findViewById(R.id.upComingMoviesRecycler)
        progressBar?.visibility = View.VISIBLE
        val call: Call<MainModelClass?>? =
            RetrofitSingleton.instance().getPopularMovies(API_KEY, "en", 1)
        call?.enqueue(object : Callback<MainModelClass?> {
            override fun onFailure(call: Call<MainModelClass?>, t: Throwable) {
                progressBar?.visibility = View.INVISIBLE
                Log.e("TopRated", "Something is wrong" + t.message)
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
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
        return v
    }
    private fun initiate(result: List<Result>) {
        recyclerView?.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        recyclerView?.adapter = context?.let { TopRatedAdapter(it, result) }
    }
}