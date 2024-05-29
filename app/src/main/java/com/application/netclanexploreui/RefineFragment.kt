package com.application.netclanexploreui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import com.application.netclanexploreui.databinding.FragmentRefineBinding

@Suppress("DEPRECATION")
class RefineFragment : Fragment() {
    private lateinit var binding: FragmentRefineBinding
    private var counter = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_refine, container, false)
        val options = arrayOf(
            "Available | Hey Let Us Connect",
            "Away | Stay Discrete And Watch",
            "Busy | Do Not Disturb | Will Catch Up Later",
            "SOS | Emergency! Need Assistance! HELP"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.optionsDropDown.adapter = adapter
        val textWatcher = (object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.inputs.text = binding.inputFieldEditText.text.toString().length.toString()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.inputs.text = s.toString().length.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.inputFieldEditText.addTextChangedListener(textWatcher)

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.valueLabel.text = progress.toString() + "Km"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        //Initializing the variables for each button to false by default because the is not clicked yet.
        var isCoffeeButtonClicked = false
        var isBusinessButtonClicked = false
        var isHobbiesButtonClicked = false
        var isFriendshipButtonClicked = false
        var isMoviesButtonClicked = false
        var isDinningButtonClicked = false
        var isDatingButtonClicked = false
        var isMatrimonyButtonClicked = false

        //Setting up the click listeners for each button.
        binding.coffeeButton.setOnClickListener {
                isCoffeeButtonClicked = buttonBackgroundHandler(isCoffeeButtonClicked,binding.coffeeButton)
        }

        binding.businessButton.setOnClickListener {
            isBusinessButtonClicked = buttonBackgroundHandler(isBusinessButtonClicked,binding.businessButton)
        }

        binding.hobbiesButton.setOnClickListener {
            isHobbiesButtonClicked = buttonBackgroundHandler(isHobbiesButtonClicked,binding.hobbiesButton)
        }

        binding.friendshipButton.setOnClickListener {
            isFriendshipButtonClicked = buttonBackgroundHandler(isFriendshipButtonClicked,binding.friendshipButton)
        }

        binding.moviesButton.setOnClickListener {
            isMoviesButtonClicked = buttonBackgroundHandler(isMoviesButtonClicked,binding.moviesButton)
        }

        binding.diningButton.setOnClickListener {
            isDinningButtonClicked = buttonBackgroundHandler(isDinningButtonClicked,binding.diningButton)
        }

        binding.datingButton.setOnClickListener {
            isDatingButtonClicked = buttonBackgroundHandler(isDatingButtonClicked,binding.datingButton)
        }

        binding.matrimonyButton.setOnClickListener {
            isMatrimonyButtonClicked = buttonBackgroundHandler(isMatrimonyButtonClicked,binding.matrimonyButton)
        }





        return binding.root
    }

    //Function to change the background of the button and it's text color on the basis of clicked or not clicked.
    private fun buttonBackgroundHandler(isClicked: Boolean,button:Button): Boolean {
        val returnBoolean: Boolean
        if (!isClicked) {
            button.setBackgroundColor(resources.getColor(com.google.android.material.R.color.material_dynamic_primary20))
            button.setTextColor(resources.getColor(R.color.white))
            returnBoolean = true
        } else {
            button.setBackgroundColor(resources.getColor(R.color.white))
            button.setTextColor(resources.getColor(com.google.android.material.R.color.material_dynamic_primary20))
            returnBoolean = false
        }
        return returnBoolean
    }


}