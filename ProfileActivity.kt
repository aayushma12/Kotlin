package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile) // Make sure the layout matches

        // Initialize TextViews to display data
        val fullNameText = findViewById<TextView>(R.id.fullNameText)
        val emailText = findViewById<TextView>(R.id.emailText)
        val genderText = findViewById<TextView>(R.id.genderText)
        val countryText = findViewById<TextView>(R.id.countryText)
        val cityText = findViewById<TextView>(R.id.cityText)

        // Retrieve data from the Intent
        val fullName = intent.getStringExtra("FULL_NAME")
        val email = intent.getStringExtra("EMAIL")
        val gender = intent.getStringExtra("GENDER")
        val country = intent.getStringExtra("COUNTRY")
        val city = intent.getStringExtra("CITY")

        // Display the received data in TextViews
        fullNameText.text = "Full Name: $fullName"
        emailText.text = "Email: $email"
        genderText.text = "Gender: $gender"
        countryText.text = "Country: $country"
        cityText.text = "City: $city"
    }
}
