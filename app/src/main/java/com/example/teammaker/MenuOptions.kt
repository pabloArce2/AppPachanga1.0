package com.example.teammaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MenuOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuoptions)

        var numberOfTeamsTextView = findViewById<TextView>(R.id.numberOfTeams)
        var plusButton = findViewById<Button>(R.id.plus_button)
        var minusButton = findViewById<Button>(R.id.m_button)
        var titleEditTextView = findViewById<TextView>(R.id.titleEditText)
        var playerSeekBar = findViewById<SeekBar>(R.id.playerSeekbar)
        var register = Register();
        var numberOfPlayers = findViewById<TextView>(R.id.numberOfPlayers)

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

        playerSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                register.setNPlayer(progress)
                numberOfPlayers.text = register.getNPlayer().toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                numberOfPlayers.visibility = View.VISIBLE
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                numberOfPlayers.visibility = View.VISIBLE
            }
        })
    }

    private fun updateNumberOfTeamsText(numberOfTeamsTextView: TextView, nTeams: Int?) {
        var text1 = getString(R.string.NoT) + " "+ nTeams;
        numberOfTeamsTextView.text = text1
    }


}
