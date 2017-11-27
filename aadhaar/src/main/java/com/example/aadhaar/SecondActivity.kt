package com.example.aadhaar

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.print.PrintAttributes
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.aadhaar.R.id.text
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.*
import org.json.JSONObject
import java.io.InputStream

class SecondActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)



        alert {
            title = "Verify Successfully..."
            yesButton {  }
        }.show()

        verticalLayout {
            background = getDrawable(R.drawable.ic_aadhar)
            toolbar {
                backgroundColor = Color.rgb(0,105,92)
                title = "Verify Activity"
                setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
                setNavigationOnClickListener{
                    onBackPressed()
                }
                setTitleTextColor(Color.WHITE)
            }.lparams(width = matchParent, height = dip(50))


            linearLayout {
                padding = dip(30)
                orientation = LinearLayout.HORIZONTAL

                imgUser=imageView(R.drawable.ic_person_black_24dp)
                {
                    id = R.string.imgUser
                    backgroundColor = Color.LTGRAY
                }.lparams(width = dip(150), height = dip(150)) {
                    horizontalMargin = dip(5)
                }

                verticalLayout {
                    padding = dip(5)
                    txtUser=textView("User_ID : ") {
                        id = R.string.txtUser
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                    txtId= textView("123456789123") {
                        id = R.string.txtId
                        textSize = 20f

                    }.lparams(width = wrapContent, height = wrapContent) {
                        verticalMargin = dip(8)
                    }
                    txtAdhar=textView("Aadhaar_Id : ") {
                        id = R.string.txtAadharnum
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                    txtNumber=textView("1212121212") {
                        id = R.string.txtNumber
                        textSize = 20f
                    }
                }
            }

            //padding = dip(5)
            txtName= textView("Name :") {
                id = R.string.txtName
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
            }
            txtDob=textView("DOB :") {
                id = R.string.txtDob
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
            }
            txtGender=textView("Gender :"){
                id = R.string.txtGender
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
            }
            txtAddress= textView("Address :"){
                id = R.string.txtAddr
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
            }
        }

        Picasso.with(applicationContext)
                .load("https://i.imgur.com/DvpvklR.png")
                .into(imgUser)

        val ist : InputStream = assets.open("json.txt")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }
        val rtObj = JSONObject(flDt)
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
