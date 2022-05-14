package com.example.componentsexample.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val networkChangeReceiver = intent?.getIntExtra(
            WifiManager.EXTRA_WIFI_STATE,
            WifiManager.WIFI_STATE_UNKNOWN
        )
        when (networkChangeReceiver) {
            WifiManager.WIFI_STATE_ENABLED -> {
                Toast.makeText(context, "WIFI is on", Toast.LENGTH_LONG).show()
            }
            WifiManager.WIFI_STATE_DISABLED ->
                Toast.makeText(context, "WIFI is off", Toast.LENGTH_LONG).show()
        }
    }
}