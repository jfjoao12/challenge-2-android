package com.example.challenge2_intents

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PangramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pangram_result) // Set the content view first
        enableEdgeToEdge()

        val resultMessage = intent.getStringExtra("result")

        val result: TextView = findViewById(R.id.pangramResultText)

        // Toast.makeText(this, resultMessage.toString(), Toast.LENGTH_SHORT).show()
        result.text = resultMessage

        // Apply window insets after the layout is fully initialized
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pangramResultText)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
