package com.example.componentsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.componentsexample.broadcastreceiver.ReceiverActivity
import com.example.componentsexample.contentprovider.ContentProviderActivity
import com.example.componentsexample.service.ServiceActivity

class MainActivity : AppCompatActivity() {

    private lateinit var receiverButton: Button
    private lateinit var contentProviderButton: Button
    private lateinit var service: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiverButton = findViewById(R.id.broadcast_receiver)
        contentProviderButton = findViewById(R.id.content_provider)
        service = findViewById(R.id.service)

        receiverButton.setOnClickListener {
            startActivity(Intent(this, ReceiverActivity::class.java))
        }

        contentProviderButton.setOnClickListener {
            startActivity(Intent(this, ContentProviderActivity::class.java))
        }

        service.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
        }
    }
}