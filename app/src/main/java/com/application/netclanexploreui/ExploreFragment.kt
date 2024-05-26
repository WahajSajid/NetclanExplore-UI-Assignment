package com.application.netclanexploreui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.application.netclanexploreui.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayoutMediator

class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_explore, container, false)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        //Creating object of FragmentStateAdapter to handle fragments
        viewPager.adapter = object : FragmentStateAdapter(this) {

            //Number of tabs for fragments
            override fun getItemCount(): Int = 3

            //Handling fragments according to tab positions
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> PersonalFragment()
                    1 -> ServicesFragment()
                    2 -> BusinessesFragment()
                    else -> Fragment()
                }
            }
        }
        //Attaching tab layout with view pager on run time
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Personal"
                1 -> "Services"
                2 -> "Businesses"
                else -> ""
            }
        }.attach()


        return binding.root
    }
}