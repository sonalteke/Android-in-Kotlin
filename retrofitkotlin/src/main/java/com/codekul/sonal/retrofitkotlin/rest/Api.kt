package com.codekul.sonal.retrofitkotlin.rest


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by sonal on 6/12/17.
 */
 class Api {
    private val PROTOCOL: String = "http"
    private val SERVER: String = "192.168.43.53"
    private val PORT: String = "8080"
    private val APP_NAME: String = "retrofit"
    val BASE_URL = "$PROTOCOL://$SERVER:$PORT/$APP_NAME/"


   var service: ApiService

    init{

    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    service = retrofit.create<ApiService>(ApiService::class.java)
}

}