package com.example.ttsapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        input = EditText(this)
        val button = Button(this)
        button.text = "Speak"

        layout.addView(input)
        layout.addView(button)

        setContentView(layout)

        tts = TextToSpeech(this, this)

        button.setOnClickListener {
            tts.language = Locale.US
            tts.speak(input.text.toString(), TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onInit(status: Int) {}
}
