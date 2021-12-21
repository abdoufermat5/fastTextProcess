package com.fermat.textgenres

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ml.quaterion.text2summary.Text2Summary

class TextSummarizerFragment: Fragment() {


    private val TAG: String = this.javaClass.simpleName
    private var textData: EditText? = null
    private var textResultData: TextView? = null
    private var btnCapture: Button? = null
    private var btnDelete: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_text_summarizer, container, false)
        btnCapture = rootView.findViewById(R.id.btnCapture)
        textResultData = rootView.findViewById(R.id.textResultData)
        btnDelete = rootView.findViewById(R.id.btnCleanText)
        textData = rootView.findViewById(R.id.textData)
        btnCapture!!.setOnClickListener {
            summary(textData!!.text.toString())
//            ImagePickerHelper.openGalleryOrCamera(this)
        }
        btnDelete!!.setOnClickListener {
            textData!!.text.clear()
            textResultData!!.text = ""
            Toast.makeText(this.requireContext(), "Texte effacé!", Toast.LENGTH_SHORT).show()
            btnDelete!!.visibility = GONE
        }
        // Inflate the layout for this fragment
        return rootView
    }

    private fun summary(text: String){
        if (text.isNotEmpty()) {
            val summary = Text2Summary.summarize(text, compressionRate = 0.3F)
            textResultData?.text = summary
            btnDelete?.visibility = VISIBLE
            Toast.makeText(this.requireContext(), "Texte résumé à 30%", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this.requireContext(), "Incorrecte", Toast.LENGTH_SHORT).show()
        }

    }
}