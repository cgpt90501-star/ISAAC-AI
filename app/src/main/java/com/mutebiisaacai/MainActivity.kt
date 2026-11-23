package com.mutebiisaacai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = "Hello Isaac! Your MutebiIsaacAI App Works!"
        textView.textSize = 24f
        textView.setPadding(50, 100, 50, 100)
        setContentView(textView)
    }
}
