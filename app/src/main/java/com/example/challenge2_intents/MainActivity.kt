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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pangramResult)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPalindrome = findViewById<Button>(R.id.btn_palindrome)


        // Function to remove all characters that are not letters and parsing them all lowercase

        // Button click to check for palindrome
//        btnPalindrome.setOnClickListener {
//            val textToFilter = txtInput.text.toString()  // Get the input text
//            val filteredText = Operations().filterInput(textToFilter)
//
//            if (operations.checkForPalindrome(filteredText)) {
//                Toast.makeText(this, "It is a palindrome!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "It is NOT a palindrome!", Toast.LENGTH_SHORT).show()
//            }
//        }



        // Button click to check for pangram

        initializeViews()
    }
    fun validateIfEmpty(str: String, ) {

    }

    private fun initializeViews() {
        val txtInput = findViewById<EditText>(R.id.txt_input).text.toString()
        val filteredInput = operations.filterInput(txtInput)
        val btnPangram = findViewById<Button>(R.id.btn_pangram)



        btnPangram.setOnClickListener {



            fun validatePangram(): String {
                val result = if (operations.checkForPangram(filteredInput)) {
                    "It is a pangram!"
                } else {
                    "It is not a pangram!"
                }
                return result
            }

            if (filteredInput != "") {
                val intent = Intent(this, PangramActivity::class.java)
                intent.putExtra("result", validatePangram())
                startActivity(intent)
            } else {
                Toast.makeText(this,
                               "Please input some text to validate!",
                               Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


        }
    }
}
