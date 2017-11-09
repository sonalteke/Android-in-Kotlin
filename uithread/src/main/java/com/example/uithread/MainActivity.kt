package com.example.uithread

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var hand:Handler?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hand= Handler(Looper.getMainLooper())
    }

    fun onOk(view: View){
       //handlerWay()
         myTask().execute(0,10)
    }

    fun handlerWay(){
        Thread{
            for (i in 1..10){
                Thread.sleep(500)
                hand?.post{txtNm.text = """ $i """}
            }
        }.start()
    }

    class myTask :AsyncTask<Int/*param*/,Int/*progress*/,Boolean/*result*/>(){

        override fun onPreExecute() {
            super.onPreExecute()
            //Ui Thread
        }

        override fun doInBackground(vararg progress: Int?): Boolean {
            //Worker Thread
            return true
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            //Ui Thread
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            //Ui thread
        }
    }
}
