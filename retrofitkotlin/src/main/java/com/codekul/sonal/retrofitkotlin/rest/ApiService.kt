package com.codekul.sonal.retrofitkotlin.rest

import com.codekul.sonal.retrofitkotlin.domain.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit



/**
 * Created by sonal on 6/12/17.
 */
interface ApiService {


    @Headers("Accept: application/json",
            "Content-Type: application/json")

    @POST("RegisterUser")
    fun userRegister(@Body user: User): Call<ResponseBody>

    companion object Factory {

        private val PROTOCOL: String = "http"
        private val SERVER: String = "192.168.43.53"
        private val PORT: String = "8080"
        private val APP_NAME: String = "User"
        val BASE_URL = "$PROTOCOL://$SERVER:$PORT/$APP_NAME/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }

}