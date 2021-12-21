package com.fermat.textgenres

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
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
    private val btnCopy: Button? = null
    private var fileUri: Uri? = null
    private var imageToProcess: Bitmap? = null
    private val Image_Capture_Code: Int = 12


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_text_summarizer, container, false)
        btnCapture = rootView.findViewById(R.id.btnCapture)
        textResultData = rootView.findViewById(R.id.textResultData)
        textData = rootView.findViewById(R.id.textData)
        btnCapture!!.setOnClickListener {
            summary(textData!!.text.toString())
//            ImagePickerHelper.openGalleryOrCamera(this)
        }
        // Inflate the layout for this fragment
        return rootView
    }

    private fun summary(text: String){
        if (text.isNotEmpty()) {
            val summary = Text2Summary.summarize(text, compressionRate = 0.3F)
            textResultData?.text = summary
        }
        Toast.makeText(this.requireContext(), "Incorrect", Toast.LENGTH_SHORT).show()
    }

//    private fun getTextFromImage(bitmap: Bitmap) {
//        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
//
//        val image = InputImage.fromBitmap(bitmap, 0)
//        recognizer.process(image)
//            .addOnSuccessListener { visionText ->
//                val text: String = preprocessText(visionText)
//                Log.d(TAG, "hello buddy: $text")
//                //textData?.text = text.toString()
//                btnCapture?.text = getString(R.string.load_text)
//                btnCopy?.visibility = View.VISIBLE
//            }
//            .addOnFailureListener {
//                Toast.makeText(
//                    this.requireContext(),
//                    "Something get wrong!! PLEASE TRY AGAIN",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//    }
//
//    private fun preprocessText(resultText: Text): String {
//        if (resultText.textBlocks.size == 0) {
//            return ""
//        }
//        var result = StringBuilder()
//        for (blockText in resultText.textBlocks) {
//            for (line in blockText.lines) {
//                result.append(line.text)
//            }
//        }
//        return result.toString()
//    }

    private fun renderError(messageResId: Int) {
        Toast.makeText(
            this.requireContext(),
            "Something get wrong!! PLEASE TRY AGAIN",
            Toast.LENGTH_LONG
        ).show()
    }
}