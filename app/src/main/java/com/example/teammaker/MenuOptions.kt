package com.example.teammaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MenuOptions : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuoptions)

        var numberOfTeamsTextView = findViewById<TextView>(R.id.numberOfTeams)
        var plusButton = findViewById<Button>(R.id.plus_button)
        var minusButton = findViewById<Button>(R.id.m_button)
        var titleEditTextView = findViewById<TextView>(R.id.titleEditText)
        var register = Register();

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            bundle.getString("name")?.let { register.setName(it) }
        }

        titleEditTextView.text = register.getName()
        updateNumberOfTeamsText(numberOfTeamsTextView, register.getNTeams())

        plusButton.setOnClickListener {
            if (register.getNTeams()!! > 9){
                Toast.makeText(this, "Too many teams!!", Toast.LENGTH_SHORT).show()
            }
            else {
                register.plusTeam()
                updateNumberOfTeamsText(numberOfTeamsTextView, register.getNTeams())
            }
        }
        minusButton.setOnClickListener {
            if (register.getNTeams()!! > 0){
                register.minusTeam()
                updateNumberOfTeamsText(numberOfTeamsTextView, register.getNTeams())
            }
        }
    }

    private fun updateNumberOfTeamsText(numberOfTeamsTextView: TextView, nTeams: Int?) {
        var text1 = getString(R.string.NoT) + " "+ nTeams;
        numberOfTeamsTextView.text = text1
    }
}
