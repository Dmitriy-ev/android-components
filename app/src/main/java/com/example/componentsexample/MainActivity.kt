package com.example.componentsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.componentsexample.broadcastreceiver.ReceiverActivity
import com.example.componentsexample.contentprovider.ContentProviderActivity

class MainActivity : AppCompatActivity() {

    private lateinit var receiverButton: Button
    private lateinit var contentProviderButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiverButton = findViewById(R.id.broadcast_receiver)
        contentProviderButton = findViewById(R.id.content_provider)

        receiverButton.setOnClickListener {
            startActivity(Intent(this, ReceiverActivity::class.java))
        }

        contentProviderButton.setOnClickListener {
            startActivity(Intent(this, ContentProviderActivity::class.java))
        }

    }
}