package com.example.sonal.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btnOkay=findViewById<Button>(R.id.btnOkay)
        btnOkay.setOnClickListener {
            Log.i("@codekul","welcome")
        }
    }
}
