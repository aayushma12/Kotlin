package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistrationAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_app) // Make sure the layout matches

        // Initialize views
        val fullName = findViewById<EditText>(R.id.fullName)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val countrySpinner = findViewById<Spinner>(R.id.countrySpinner)
        val cityAutoComplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val termsCheckBox = findViewById<CheckBox>(R.id.termsCheckBox)
        val submitButton = findViewById<Button>(R.id.submitButton)

        // Set up AutoCompleteTextView suggestions for cities
        val cities = arrayOf("New York", "London", "Paris", "Tokyo", "Sydney", "Mumbai")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        cityAutoComplete.setAdapter(cityAdapter)

        // Set up Spinner for countries
        val countries = arrayOf("USA", "UK", "France", "Japan", "Australia", "India")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpinner.adapter = countryAdapter

        // Set up submit button click listener
        submitButton.setOnClickListener {
            // Get selected gender
            val gender = when (genderGroup.checkedRadioButtonId) {
                R.id.male -> "Male"
                R.id.female -> "Female"
                else -> "Not Specified"
            }

            // Check if terms are agreed
            if (!termsCheckBox.isChecked) {
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pass data to ProfileActivity
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("FULL_NAME", fullName.text.toString())
                putExtra("EMAIL", email.text.toString())
                putExtra("GENDER", gender)
                putExtra("COUNTRY", countrySpinner.selectedItem.toString())
                putExtra("CITY", cityAutoComplete.text.toString())
            }

            startActivity(intent)
        }
    }
}
