package com.example.componentsexample.service

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.componentsexample.R

class ServiceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var start: Button
    private lateinit var stop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        start = findViewById(R.id.startButton)
        stop = findViewById(R.id.stopButton)

        start.setOnClickListener(this)
        stop.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            start -> startService(Intent(this, MusicService::class.java))
            stop -> stopService(Intent(this, MusicService::class.java))
        }
    }
}