package com.example.teammaker


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager


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
        var generateButton = findViewById<Button>(R.id.generateButton)
        var containerLayout = findViewById<LinearLayout>(R.id.container_layout)


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
                updateMaxPlayers(playerSeekBar, register.getNTeams())
            }
        }
        minusButton.setOnClickListener {
            if (register.getNTeams()!! > 1){
                register.minusTeam()
                updateNumberOfTeamsText(numberOfTeamsTextView, register.getNTeams())
                updateMaxPlayers(playerSeekBar, register.getNTeams())
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

        generateButton.setOnClickListener {
            val nTeam = register.getNTeams();

            val tabLayout = TabLayout(this)
            val viewPager = ViewPager(this)
            val adapter = TeamPagerAdapter(supportFragmentManager, nTeam!!)
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)

            containerLayout.addView(tabLayout)
            containerLayout.addView(viewPager)
        }
    }

    private fun updateNumberOfTeamsText(numberOfTeamsTextView: TextView, nTeams: Int?) {
        var text1 = getString(R.string.NoT) + " "+ nTeams;
        numberOfTeamsTextView.text = text1
    }
    private fun updateMaxPlayers(playerSeekBar: SeekBar, nTeams: Int?) {
        playerSeekBar.max = nTeams!! * 11
    }


}
