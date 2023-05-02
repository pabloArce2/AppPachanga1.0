package com.example.teammaker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class TeamPagerAdapter(fm: FragmentManager, val nTeams: Int) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return nTeams
    }

    override fun getItem(position: Int): Fragment {
        return TeamFragment.newInstance(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Team ${position + 1}"
    }

}