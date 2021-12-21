package com.fermat.textgenres

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    private fun copyToClipBoard(text: String) {
        var clipboard: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData: ClipData = ClipData.newPlainText("Copied Data", text)
        clipboard.setPrimaryClip(clipData)
        Toast.makeText(
            this,
            "Text Copied successfully",
            Toast.LENGTH_LONG
        ).show()

    }
}