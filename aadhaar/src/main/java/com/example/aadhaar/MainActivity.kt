package com.example.aadhaar

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.Button
import android.widget.Toast
import com.example.aadhaar.R.id.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {


    inline fun ViewManager.textInputEditText() = textInputEditText {}
    inline fun ViewManager.textInputEditText(theme: Int = 0, init: TextInputEditText.() -> Unit) = ankoView({ TextInputEditText(it) }, theme, init)

    inline fun ViewManager.textInputLayout() = textInputLayout {}
    inline fun ViewManager.textInputLayout(theme: Int = 0, init: TextInputLayout.() -> Unit) = ankoView({ TextInputLayout(it) }, theme, init)

    val ADHAR:Int=12
    lateinit var adhar:TextInputLayout
    lateinit var adharNum:TextInputEditText
    lateinit var send: Button
    lateinit var resend:Button
    lateinit var otp:TextInputLayout
    lateinit var otpNum:TextInputEditText
    lateinit var verify:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {
            backgroundColor = Color.WHITE
            lparams(width= matchParent,height = matchParent)
            padding=dip(70)
            gravity=Gravity.CENTER

            adhar =textInputLayout{
                adharNum = textInputEditText {
                    id = R.id.txtNum
                    textSize=20f
                    hint="Enter Aadhar Number"
                }
            }

            linearLayout {

                padding=dip(20)
                gravity=Gravity.CENTER


                send = button("Send OTP") {
                    id = R.id.btnSend
                    backgroundColor=Color.rgb(77, 182, 172)
                    textColor = Color.rgb(0, 77, 64)
                    typeface= Typeface.DEFAULT_BOLD

//                     backgroundColor = Color.rgb(128, 203, 196)

                }.lparams(width= wrapContent,height = wrapContent){
                    horizontalMargin = dip(5)
                }


                resend = button("Resend OTP") {
                    id = R.id.btnResend
                    backgroundColor = Color.rgb(77, 182, 172)
//                    backgroundColor = Color.rgb(128, 203, 196)
                    textColor = Color.rgb(0, 77, 64)
                    typeface= Typeface.DEFAULT_BOLD
                    visibility=View.INVISIBLE
                    onClick {
                        background = buttonBg()
                        toast("OTP Resend")
                    }
                }.lparams(width= wrapContent,height = wrapContent){
                    gravity = Gravity.CENTER
                }

        }


            verticalLayout {
                gravity = Gravity.CENTER
                padding = dip(30)

                otp =  textInputLayout {
                    otpNum=  textInputEditText {
                        id = R.id.txtOtp
                        textSize=20f
                        hint="Enter OTP"
                        inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                    }
                    visibility=View.INVISIBLE
                }

                linearLayout {

                    padding = dip(20)
                    lparams(width = wrapContent, height = wrapContent)

                    verify=button("verify") {
                        id = R.id.btnVerify
                        text = "Verify"
                        background=buttonBg()
//                        backgroundColor = Color.rgb(77, 182, 172)
                        textColor = Color.rgb(0, 77, 64)
                        typeface= Typeface.DEFAULT_BOLD
                        visibility=View.INVISIBLE
                        onClick {
                            if(otpNum.text.isNotEmpty()) {
                                startActivity(Intent(applicationContext,
                                        Verify2Activity::class.java))
                                otpNum.text.clear()
                                send.backgroundColor=Color.rgb(77, 182, 172)
                                resend.backgroundColor=Color.rgb(77, 182, 172)

                            }
                            else{
                                toast("Enter OTP First..!!")
                            }
                        }
                    }
                }
            }
        }

        send.onClick {

            send.background=buttonBg()

            if (adharNum.text.isNotEmpty()) {
                if (adharNum.text.length==ADHAR) {

                    resend.visibility=View.VISIBLE
                    otp.visibility=View.VISIBLE
                    verify.visibility=View.VISIBLE
                    toast("OTP Send")
                    adharNum.text.clear()
                }
                else{
                    toast("Please Enter Valid Adhar Number..!!")
                }
            }
            else{
                toast("Please Enter Adhar Number First..!!")
            }
        }
    }
    fun buttonBg() = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = 6f
        setStroke(2, Color.rgb(0, 77, 64))
    }
}



