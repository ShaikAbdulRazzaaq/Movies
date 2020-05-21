package com.assignment.movies.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.RetrofitSingleton
import com.assignment.movies.adapters.TopRatedAdapter
import com.assignment.movies.data.MainModelClass
import com.assignment.movies.data.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRated : Fragment() {
    private val API_KEY = "73884879dfa3d28cc666c9b18d79c862"
    var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.top_rated_fragment, container, false)
        recyclerView = v.findViewById(R.id.topRatedRecycler)

        val call: Call<MainModelClass?>? =
            RetrofitSingleton.instance().getTopRatedMovies(API_KEY, "en", 1)
        call?.enqueue(object : Callback<MainModelClass?> {
            override fun onFailure(call: Call<MainModelClass?>, t: Throwable) {
                Log.e("TopRated", "Something is wrong" + t.message)
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<MainModelClass?>,
                response: Response<MainModelClass?>
            ) {
                val result = response.body()?.results
                Log.e("tag"," "+response.body()?.results?.size)
                if (result != null) {
                    initiate(result)
                }
            }
        })
        return (v)
    }
    private fun initiate(result: List<Result>) {
        recyclerView?.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        recyclerView?.adapter= context?.let { TopRatedAdapter(it,result) }
    }

}




