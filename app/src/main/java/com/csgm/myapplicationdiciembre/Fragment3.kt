package com.csgm.myapplicationdiciembre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment3 : Fragment() {
    private lateinit var numberTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image3, container, false)
/*        val view = inflater.inflate(R.layout.fragment_image3, container, false)
        numberTextView = view.findViewById(R.id.numberTextView)
        return view*/
    }


}