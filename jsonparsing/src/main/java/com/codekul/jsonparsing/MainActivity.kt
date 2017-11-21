package com.codekul.jsonparsing

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ist :InputStream = assets.open("my.txt")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }
         val rtObj =JSONObject(flDt)
        Log.i("@codekul","""Name= ${rtObj.getString("nm")}""")
        Log.i("@codekul","""Age= ${rtObj.getInt("age")}""")
        Log.i("@codekul","""Indian= ${rtObj.getBoolean("isIndian")}""")
        Log.i("@codekul","""Salary= ${rtObj.getLong("sal")}""")

        val inrObj = rtObj.getJSONObject("grp")
        Log.i("@codekul","""Title = ${inrObj.getString("ttl")}""")

        val mobs = rtObj.getJSONArray("mobs")
        mobs.iterator().forEach {
            Log.i("@codekul","""$it""")
        }
    }

    private operator fun JSONArray.iterator(): Iterator<String>
            = (0 until length()).asSequence().map { get(it) as String }.iterator()
}
