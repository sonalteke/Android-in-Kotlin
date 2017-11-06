package com.example.servicesmediaplayer

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    var intentservice:Intent?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentservice=Intent(this,MyService::class.java)
    }

    fun onPlay(view:View?){
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            startForegroundService(intentservice)
        }
        else
        {
            startService(intentservice)
        }
            }

    fun onStop(view: View?){
        stopService(intentservice)
    }
}
