package com.example.aadharcardverify

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnVerify.visibility = View.INVISIBLE
        edtOtp.visibility = View.INVISIBLE
        btnResend.visibility = View.INVISIBLE

        btnSend.setOnClickListener {
            if (edtAadhar.text.isNotEmpty()) {
                var int: Int = edtAadhar.text.length
                if (int == 12) {
                    btnVerify.visibility = View.VISIBLE
                    edtOtp.visibility = View.VISIBLE
                    btnResend.visibility = View.VISIBLE

                    edtAadhar.text = null
                    edtAadhar.hint = null
                } else {
                    Toast.makeText(this, "Enter proper Aadhar Number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter Aadhar Number", Toast.LENGTH_SHORT).show()
            }

        }

        btnVerify.setOnClickListener {
            startActivity(Intent(applicationContext, VerifyActivity::class.java))

        }
    }
}