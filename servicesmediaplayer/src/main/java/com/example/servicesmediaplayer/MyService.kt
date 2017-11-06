package com.example.servicesmediaplayer

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.support.v4.app.NotificationCompat

class MyService : Service() {

    private var mp: MediaPlayer?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mp = MediaPlayer.create(this,R.raw.my)
        mp?.start()

        showInForeground()
        return START_STICKY
    }

    override fun onDestroy() {
        mp?.stop()
        mp?.start()
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
        }

    private fun showInForeground(){

        val notiManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){

            val id="1234"
            val name="normal"
            val description="description"
            val importance=android.app.NotificationManager.IMPORTANCE_LOW
            val mchannel=NotificationChannel(id,name,importance)
            mchannel.description=description
            mchannel.enableLights(true)
            mchannel.lightColor= Color.RED
            mchannel.enableVibration(true)

            val builder=NotificationCompat.Builder(this,"1234")
            builder.setSmallIcon(R.drawable.ic_music_note_black_24dp)
                    .setContentText("Content Text")
                    .setContentInfo("Info")
                    .setContentTitle("Title")

        val mNotificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(mchannel)
            startForeground(1234,builder.build())
        }
        else
        {
            val builder = NotificationCompat.Builder(this)
            builder.setSmallIcon(R.drawable.ic_music_note_black_24dp)
                    .setContentText("Content Text")
                    .setContentInfo("Info")
                    .setContentTitle("Title")
            val notification = builder.build()
            startForeground(1234, notification)
        }

        }

    }

