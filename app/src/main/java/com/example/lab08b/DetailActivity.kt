package com.example.lab08b

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab08b.databinding.ActivityMainBinding
import android.content.Intent
import android.graphics.Color
import android.widget.Toast
import com.example.lab08b.databinding.ActivityOrderSummaryBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.sizeTextView.text = intent.getStringExtra("size")
        binding.dateTextView.text = intent.getStringExtra("date")
        binding.timeTextView.text = intent.getStringExtra("time")

        binding.sendBtn.setOnClickListener {
            /*binding.ratingTextView.text = binding.ratingBar.rating.toString()
            Snackbar.make(view,"Thank you for your rating, we received it!",Snackbar.LENGTH_LONG).show()*/
            binding.ratingTextView.text = binding.ratingBar.rating.toString()
            Snackbar.make(view,"Thank you for your rating, we received it!",Snackbar.LENGTH_LONG).setAction("OK") {
                println("OK button pressed")
            }.show()
        }
        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            // Update the TextView with the current rating
            binding.ratingTextView.text = "$rating"
        }
    }


}