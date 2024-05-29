package com.application.netclanexploreui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.application.netclanexploreui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initializing binding
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val navigationHost = supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment
        val navController = navigationHost.navController
        binding.bottomNavigationView.setupWithNavController(navController)


    }


}