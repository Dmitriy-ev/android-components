package com.example.componentsexample.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicService: Service() {

    private lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //мелодия по умолчанию
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        //цикл воспроизведения
        player.isLooping = true
        //старт
        player.start()
        //статус
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}