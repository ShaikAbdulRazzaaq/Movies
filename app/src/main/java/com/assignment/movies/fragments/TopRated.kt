package com.assignment.movies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movies.R
import com.assignment.movies.adapters.topRatedAdapter
import com.assignment.movies.dataTopRated.Result
import com.assignment.movies.viewModels.ViewModelTopRated


class TopRated : Fragment() {
     private lateinit var recyclerView: RecyclerView
     private lateinit var progressBar: ProgressBar
    private lateinit var modelTopRated: ViewModelTopRated
    private lateinit var topRatedAdapter: topRatedAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.top_rated_fragment, container, false)
        progressBar=v.findViewById(R.id.progressBar)
        recyclerView = v.findViewById(R.id.topRatedRecycler)
        progressBar.visibility=View.VISIBLE
        modelTopRated = ViewModelProvider(requireActivity()).get(ViewModelTopRated::class.java)
        recyclerView.layoutManager = LinearLayoutManager(v.context, RecyclerView.VERTICAL, false)
        models()
        return (v)
    }

    private fun models() {

        modelTopRated.showProgress.observe(viewLifecycleOwner, Observer {
            if (it) {
                progressBar.visibility = View.VISIBLE
                modelTopRated.networkCall()
            }
            else
                progressBar.visibility=View.INVISIBLE
        })
        modelTopRated.topRated.observe(viewLifecycleOwner, Observer {
            topRatedAdapter.settopRated(it)
        })

        initItems()
    }

    private fun initItems() {
        var list:List<Result>?=null
recyclerView.adapter= list?.let { context?.let { it1 -> topRatedAdapter(it1, it) } }
    }
}
