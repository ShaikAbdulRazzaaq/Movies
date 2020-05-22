package com.assignment.movies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.assignment.movies.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class viewPager : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private var tabTitle= arrayOf("Upcoming Movies","Top-Rated Movies")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.viewpager, container, false)
        viewPager2 = view.findViewById(R.id.viewPager)
        viewPager2.adapter = ViewPagerAdapter(this)
        tabLayout = view.findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
        return view
    }
}

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 1)
            TopRated()
        else Upcoming()
    }
}