package com.example.teammaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MenuOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuoptions)

        var numberOfTeamsTextView = findViewById<TextView>(R.id.numberOfTeams)
        var plusButton = findViewById<Button>(R.id.plus_button)
        var minusButton = findViewById<Button>(R.id.m_button)

        var register1 = register(2)

        updateNumberOfTeamsText(numberOfTeamsTextView, register1.getNTeams())

        plusButton.setOnClickListener {
            if (register1.getNTeams()!! > 10){
                Toast.makeText(this, "Too many teams!!", Toast.LENGTH_SHORT).show()
            }
            else {
                register1.plusTeam()
                updateNumberOfTeamsText(numberOfTeamsTextView, register1.getNTeams())
            }
        }
        minusButton.setOnClickListener {
            if (register1.getNTeams()!! > 0){
                register1.minusTeam()
                updateNumberOfTeamsText(numberOfTeamsTextView, register1.getNTeams())
            }
        }
    }

    private fun updateNumberOfTeamsText(numberOfTeamsTextView: TextView, nTeams: Int?) {
        var text1 = getString(R.string.NoT) + nTeams;
        numberOfTeamsTextView.text = text1
    }
}
