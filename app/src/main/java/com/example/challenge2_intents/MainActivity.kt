package com.example.challenge2_intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val operations = Operations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPalindrome = findViewById<Button>(R.id.btn_palindrome)
        val txtInput = findViewById<EditText>(R.id.txt_input)
        val btnPangram = findViewById<Button>(R.id.btn_pangram)

        val txtResult = findViewById<TextView>(R.id.txt_result)
        // Function to remove all characters that are not letters and parsing them all lowercase
        fun filterInput(str: String): String {
            val filtered = str.lowercase().filter { it.isLetter() }
            return filtered

        }
        // Button click to check for palindrome
        btnPalindrome.setOnClickListener {
            val textToFilter = txtInput.text.toString()  // Get the input text
            val filteredText = filterInput(textToFilter)

            if (operations.checkForPalindrome(filteredText)) {
                Toast.makeText(this, "It is a palindrome!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "It is NOT a palindrome!", Toast.LENGTH_SHORT).show()
            }
        }

        // Button click to check for pangram

    }
}
