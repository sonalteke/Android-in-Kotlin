package com.example.aadhaar

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_verify2.*
import org.jetbrains.anko.*
import org.json.JSONObject
import java.io.InputStream


class Verify2Activity : AppCompatActivity() {

    lateinit var imgUser : ImageView
    lateinit var txtUser : TextView
    lateinit var txtAdhar : TextView
    lateinit var txtId : TextView
    lateinit var txtNumber : TextView
    lateinit var txtName : TextView
    lateinit var txtDob : TextView
    lateinit var txtGender : TextView
    lateinit var txtAddress : TextView



    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify2)
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        alert {
            customView {
                verticalLayout {
                    textView {
                        text = "Verified Successfully..."
                        textSize = 30f
                        typeface = Typeface.DEFAULT_BOLD
                        backgroundColor = Color.rgb(0,137,123)
                        textColor = Color.WHITE
                    }

                    linearLayout {
                        padding = dip(5)
                        orientation = LinearLayout.HORIZONTAL

                     imgUser=imageView(R.drawable.ic_person_black_24dp)
                        {
                            id = R.string.imgUser
                            backgroundColor = Color.LTGRAY
                        }.lparams(width = dip(130), height = dip(130)) {
                            horizontalMargin = dip(5)
                        }

                        verticalLayout {
                            padding = dip(10)
                         txtUser=textView {
                                id = R.string.txtUser
                                text = "User_Id : "
                                textSize = 20f
                                typeface = Typeface.DEFAULT_BOLD
                            }
                         txtId= textView {
                                id = R.string.txtId
                                text = "123456789123"
                                textSize = 20f

                            }.lparams(width = wrapContent, height = wrapContent) {
                                verticalMargin = dip(8)
                            }
                           txtAdhar=textView {
                                id = R.string.txtAadharnum
                                text = "Aadhaar_Id : "
                                textSize = 20f
                                typeface = Typeface.DEFAULT_BOLD
                            }
                           txtNumber=textView {
                                id = R.string.txtNumber
                                text = "121212121212"
                                textSize = 20f
                            }
                        }
                    }

                    padding = dip(5)
                    txtName=textView {
                        id = R.string.txtName
                        text = "Name :"
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                    txtDob=textView {
                        id = R.string.txtDob
                        text = "DOB :"
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                   txtGender=textView {
                        id = R.string.txtGender
                        text = "Gender :"
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                   txtAddress= textView {
                        id = R.string.txtAddr
                        text = "Address :"
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                }
            }
        }.show()

        Picasso.with(applicationContext)
                .load("https://i.imgur.com/DvpvklR.png")
                .into(imgUser)

        val ist :InputStream = assets.open("json.txt")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }
        val rtObj =JSONObject(flDt)
        val name : String = rtObj.getString("name")
        val dob : String = rtObj.getString("dob")
        val gender : String = rtObj.getString("gender")
        val address : String = rtObj.getString("address")


        if (txtName.text.isNotEmpty()) {
            txtName.append(name)
        }
        if (txtDob.text.isNotEmpty()) {
            txtDob.append(dob)
        }
        if (txtGender.text.isNotEmpty()) {
            txtGender.append(gender)
        }
        if (txtAddress.text.isNotEmpty()) {
            txtAddress.append(address)
        }

    }
}
