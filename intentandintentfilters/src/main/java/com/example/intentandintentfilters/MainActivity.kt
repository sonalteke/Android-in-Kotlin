package com.example.intentandintentfilters

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnok.setOnClickListener {
            //dial()
           // call()
           // web()
            simple()
        }
    }

    private fun dial(){
        val callintent=Intent(Intent.ACTION_DIAL)
        startActivity(callintent)
    }


    private fun call(){
        val callintent=Intent(Intent.ACTION_CALL)
        callintent.data= Uri.parse("tel://7745842310")
        startActivity(callintent) //give permission
    }

    private fun web(){
        val webintent=Intent(Intent.ACTION_VIEW)
        webintent.data=Uri.parse("http://codekul.com")
        startActivity(webintent)
    }

    private fun simple(){
        val intent=Intent()
        intent.action="com.codekul.action.SIMPLE"
        intent.addCategory("com.codekul.category.PQR")
        intent.data= Uri.parse("http://codekul.com")
        startActivity(intent)
    }
}

