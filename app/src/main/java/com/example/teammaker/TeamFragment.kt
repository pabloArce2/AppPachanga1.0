package com.example.teammaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TeamFragment : Fragment() {
    companion object {

        fun newInstance(position: Int): TeamFragment {
            val fragment = TeamFragment()
            val args = Bundle()
            args.putInt("position", position)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.team_fragment, container, false)
        val position = arguments?.getInt("position") ?: 0
        val textView = view.findViewById<TextView>(R.id.teamTitle)
        textView.text = "Team ${position + 1}"
        return view
    }
}
