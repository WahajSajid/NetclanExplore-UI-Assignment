package com.application.netclanexploreui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.application.netclanexploreui.databinding.FragmentBusinessesBinding

class BusinessesFragment : Fragment() {
    private lateinit var binding:FragmentBusinessesBinding
    private var isExpanded = false

    //Initialize Animation
    private val fromBottomFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.from_bottom_fab)
    }
    private val toBottomFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.to_bottom_fab)
    }
    private val rotateClockWiseFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.clock_wise)
    }
    private val rotateAntiClockWiseFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.anti_clock_wise)
    }
    private val fromBottomBgAnim: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.from_bottom_anim)
    }
    private val toBottomBgAnim: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.to_bottom_anim)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_businesses, container, false)

        view?.setFocusableInTouchMode(true)
        view?.requestFocus()

        //Setting up click listener for main fabButton to show animation on click
        binding.mainFabBtn.setOnClickListener {
            if(isExpanded) shrinkFab()
            else expandFab()
        }
        return binding.root

    }



    @SuppressLint("ResourceAsColor")
    //Function to shrink and expand fabButton
    private fun shrinkFab(){
        binding.transparentBg.visibility = View.GONE
        binding.mainFabBtn.startAnimation(rotateAntiClockWiseFabAnim)
        binding.notesFabBtn.startAnimation(toBottomFabAnim)
        binding.jobsFabBtn.startAnimation(toBottomFabAnim)
        binding.netClanGroupsFabBtn.startAnimation(toBottomFabAnim)
        binding.businessCardsFabBtn.startAnimation(toBottomFabAnim)
        binding.buySellRentFabBtn.startAnimation(toBottomFabAnim)
        binding.matriMoneyFabBtn.startAnimation(toBottomFabAnim)
        binding.datingFabBtn.startAnimation(toBottomFabAnim)
        binding.notesTv.startAnimation(toBottomFabAnim)
        binding.jobsTv.startAnimation(toBottomFabAnim)
        binding.netClanGroupsTv.startAnimation(toBottomFabAnim)
        binding.businessCardsTv.startAnimation(toBottomFabAnim)
        binding.buySellRentTv.startAnimation(toBottomFabAnim)
        binding.matriMoneyTv.startAnimation(toBottomFabAnim)
        binding.datingTv.startAnimation(toBottomFabAnim)
        isExpanded = !isExpanded
    }
    @SuppressLint("ResourceAsColor")
    private fun expandFab(){
        binding.transparentBg.visibility = View.VISIBLE
        binding.mainFabBtn.startAnimation(rotateClockWiseFabAnim)
        binding.notesFabBtn.startAnimation(fromBottomFabAnim)
        binding.jobsFabBtn.startAnimation(fromBottomFabAnim)
        binding.netClanGroupsFabBtn.startAnimation(fromBottomFabAnim)
        binding.businessCardsFabBtn.startAnimation(fromBottomFabAnim)
        binding.buySellRentFabBtn.startAnimation(fromBottomFabAnim)
        binding.matriMoneyFabBtn.startAnimation(fromBottomFabAnim)
        binding.datingFabBtn.startAnimation(fromBottomFabAnim)
        binding.notesTv.startAnimation(fromBottomFabAnim)
        binding.jobsTv.startAnimation(fromBottomFabAnim)
        binding.netClanGroupsTv.startAnimation(fromBottomFabAnim)
        binding.businessCardsTv.startAnimation(fromBottomFabAnim)
        binding.buySellRentTv.startAnimation(fromBottomFabAnim)
        binding.matriMoneyTv.startAnimation(fromBottomFabAnim)
        binding.datingTv.startAnimation(fromBottomFabAnim)
        isExpanded = !isExpanded
    }
}