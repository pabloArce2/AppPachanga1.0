package com.example.teammaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entryButton = findViewById<Button>(R.id.entry)
        entryButton.setOnClickListener {
            val intent = Intent(this, MenuOptions::class.java)
            startActivity(intent)
        }
    }



}