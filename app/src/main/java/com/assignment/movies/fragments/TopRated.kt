package com.assignment.movies.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.adapters.topRatedAdapter
import com.assignment.movies.dataTopRated.MoviesTopRated
import com.assignment.movies.dataTopRated.Result
import com.assignment.movies.interfaces.TopRatedMoviesInterface
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TopRated : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.top_rated_fragment, container, false)
         recyclerView = v.findViewById(R.id.topRatedRecycler)
        recyclerView.layoutManager = LinearLayoutManager(v.context, RecyclerView.VERTICAL, false)
        initItems()
        return (v)
    }

    private fun initItems() {

        val gson = GsonBuilder()
            .setLenient()
            .create()

      val retrofit=Retrofit.Builder().baseUrl("https://developers.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create(gson)).build()
        val service=retrofit.create(TopRatedMoviesInterface::class.java)
        val call=service.getTopRatedMovies("73884879dfa3d28cc666c9b18d79c862")
        call?.enqueue(object : Callback<MoviesTopRated?> {
            override fun onResponse(
                call: Call<MoviesTopRated?>,
                response: Response<MoviesTopRated?>
            ) {
                if(response.isSuccessful)
                addtorecycler(response.body())
                Log.e("SUCCESS", "DATA FOUND ")

            }

            override fun onFailure(call: Call<MoviesTopRated?>, t: Throwable) {
                Log.e("FAILED", t.message + "")
            }
        })

    }
    private fun addtorecycler(body: MoviesTopRated?) {
        val list: List<Result> = body?.results!!
        recyclerView.adapter= context?.let { topRatedAdapter(it,list) }
    }

}
