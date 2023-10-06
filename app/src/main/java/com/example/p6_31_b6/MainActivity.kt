package com.example.p6_31_b6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var togglePlayButton = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton = findViewById<FloatingActionButton>(R.id.play_button)
        val stopButton = findViewById<FloatingActionButton>(R.id.stop_button)

        playButton.setOnClickListener{
            Intent(applicationContext,MyService::class.java).putExtra("Service1","PlayPause").apply { startService(this) }
            if(togglePlayButton){
                togglePlayButton = false;
                playButton.setImageResource(R.drawable.baseline_pause_24)
            }
            else{
                togglePlayButton = true;
                playButton.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }
        stopButton.setOnClickListener{
            Intent(applicationContext,MyService::class.java).apply { stopService(this) }
        }
        if(togglePlayButton){
            togglePlayButton = true;
            playButton.setImageResource(R.drawable.baseline_play_arrow_24)
        }
    }
}