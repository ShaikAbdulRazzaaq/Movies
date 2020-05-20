package com.assignment.movies.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.DetailedActivity
import com.assignment.movies.R
import com.assignment.movies.RetrofitSingleton
import com.assignment.movies.adapters.topRatedAdapter
import com.assignment.movies.data.MainModelClass
import com.assignment.movies.data.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRated : Fragment() {
    private val API_KEY = "73884879dfa3d28cc666c9b18d79c862"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.top_rated_fragment, container, false)
        val recyclerView: RecyclerView = v.findViewById(R.id.topRatedRecycler)
        recyclerView.layoutManager = LinearLayoutManager(v.context, RecyclerView.VERTICAL, false)
        val call: Call<MainModelClass?>? =
            RetrofitSingleton.instance().getPopularMovies(API_KEY, "en", 1)
        call?.enqueue(object : Callback<MainModelClass?> {
            override fun onFailure(call: Call<MainModelClass?>, t: Throwable) {
                Log.i("TopRated", "Something is wrong" + t.message)
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<MainModelClass?>,
                response: Response<MainModelClass?>
            ) {
                val result = response.body()?.results
                if (result != null) {
                    initiate(result)
                }
            }
        })
        return (v)
    }

    private fun initiate(result: List<Result>) {


    }

}




