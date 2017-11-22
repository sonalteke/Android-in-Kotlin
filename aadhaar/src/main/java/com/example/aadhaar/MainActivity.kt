package com.example.aadhaar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {
            padding = dip(70)
            editText {
                id = R.id.edtAadhar
                hint = "Enter Aadhar number:"
                textSize = 20f
            }

            linearLayout {
                gravity = Gravity.CENTER
                padding = dip(20)

                lparams(width = wrapContent, height = wrapContent)
                button {
                    id = R.id.btnSend
                    text = "Send OTP"
                    onClick {
                        Toast.makeText(this@MainActivity,
                                "send OTP",Toast.LENGTH_SHORT).show()
                    }
                }
                button {
                    id = R.id.btnResend
                    text = "Resend OTP"
                    onClick {
                        Toast.makeText(this@MainActivity,
                                "Resend OTP",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            verticalLayout {
                gravity = Gravity.CENTER
                padding = dip(30)
                editText {
                    id = R.id.edtOtp
                    hint = "Enter OTP:"
                    textSize = 20f

                }.lparams(width = wrapContent,height = wrapContent)

                linearLayout {
                    padding = dip(20)

                    lparams(width = wrapContent, height = wrapContent)
                    button {
                        id = R.id.btnVerify
                        text = "Verify"
                        onClick {
                            startActivity(Intent(this@MainActivity,
                                    Verify2Activity::class.java))
                        }
                    }
                }
            }
        }
    }
}



