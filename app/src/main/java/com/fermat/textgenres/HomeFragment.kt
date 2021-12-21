package com.fermat.textgenres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btn1: Button = view.findViewById(R.id.btn1)
        val btn2: Button = view.findViewById(R.id.btn2)

        btn1.setOnClickListener { findNavController().navigate(R.id.homeToSummarizer) }
        btn2.setOnClickListener { findNavController().navigate(R.id.homeToGenerator) }
        super.onViewCreated(view, savedInstanceState)
    }
}