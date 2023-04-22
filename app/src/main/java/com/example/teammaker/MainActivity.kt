package com.example.teammaker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val entryButton = findViewById<Button>(R.id.entry)

        entryButton.setOnClickListener {
            val name : String = nameEditText.text.toString()

            val intent = Intent(this, MenuOptions::class.java)
            val bundle = Bundle().apply { putString("name", name) }
            intent.putExtras(bundle)

            startActivity(intent)
        }


    }



}