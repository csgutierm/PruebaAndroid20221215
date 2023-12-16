package com.csgm.myapplicationdiciembre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {
    //private lateinit var numberTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
/*        val view = inflater.inflate(R.layout.fragment_image, container, false)
        numberTextView = view.findViewById(R.id.numberTextView)
        return view*/
    }


}