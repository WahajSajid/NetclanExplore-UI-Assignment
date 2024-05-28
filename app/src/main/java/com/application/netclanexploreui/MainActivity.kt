package com.application.netclanexploreui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.application.netclanexploreui.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initializing binding
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


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


    }
}