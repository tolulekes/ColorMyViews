package com.toluleke.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.toluleke.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> =
                listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, constraintLayout, redButton, yellowButton, greenButton)

            for (item in clickableViews) {
                item.setOnClickListener { makeColored(it) }
            }
            invalidateAll()
        }
    }

    private fun makeColored(view: View) {

        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            //Boxes changing colors based on touch
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            //Boxes using custom colors for background
            R.id.redButton -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellowButton -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.greenButton -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            //Changing the background of the picture
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}