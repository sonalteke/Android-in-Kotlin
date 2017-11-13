package com.example.uithread

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AlertDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    var hand:Handler?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hand= Handler(Looper.getMainLooper())
    }

    fun onOk(view: View){
        // handlerWay()
         //myTask().execute(0,10)

        val dialog=AlertDialog.Builder(this).setTitle("Android").create()

        doAsync {
            uiThread {
                dialog.show()
            }
            for(i in 1..10){
                uiThread {
                    txtNm.text = """ $i """
                }
                Thread.sleep(500)
            }
            uiThread {
                dialog.dismiss()
            }
        }
    }

    fun handlerWay(){
        Thread{
            for (i in 1..10){
                Thread.sleep(500)
                hand?.post{txtNm.text = """ $i """}
                //txtNm.text = """ $i """
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
