package com.example.dialogs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlert.setOnClickListener{
            showDialog("alert")
        }
        btnDate.setOnClickListener{
            showDialog("datepicker")
        }
        btnTime.setOnClickListener {
            showDialog("timepicker")
        }
        btnCust.setOnClickListener {
            showDialog("custom")
        }
    }
    private fun showDialog(tag: String){
        val diafrag=BlankFragment()
        diafrag.show(supportFragmentManager,tag)
    }
}
