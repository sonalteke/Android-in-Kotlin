package com.codekul.sonal.retrofitkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.codekul.sonal.retrofitkotlin.R.id.*
import com.codekul.sonal.retrofitkotlin.domain.User
import com.codekul.sonal.retrofitkotlin.rest.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class MainActivity : AppCompatActivity() {

    lateinit var apiService: ApiService
    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editCity: EditText
    lateinit var editOtpno :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         editName = findViewById(R.id.editName)
         editEmail = findViewById(R.id.editEmailId)
        editPassword = findViewById(R.id.editPassword)
         editCity = findViewById(R.id.editCity)
        editOtpno = findViewById(R.id.editOtpno)

        register.setOnClickListener {
            getPostData()
        }
    }

    private fun getPostData() {
        apiService = ApiService.create()

        val call = apiService.userRegister(User(editName.text.toString(),editEmail.text.toString(),editPassword
                .text.toString(),editCity.text.toString(),editOtpno.text.toString()))

        Log.i("@codekul", """url = ${call.request().url()}""")
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                //                DtoInfo dtoInfo= response.body();
                //                String message = dtoInfo.getMessage();
                //                Log.i("@codekul"," resp : " +message);
                Log.i("@codekul ", "response " + response)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("@codekul", "error msg " + call + " thro " + t.message)
            }
        })
    }
}



