package com.example.componentsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var receiverButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiverButton = findViewById(R.id.broadcast_receiver)
        receiverButton.setOnClickListener {
            val receiver = Intent(this, ReceiverActivity::class.java)
            startActivity(receiver)
        }

    }
}