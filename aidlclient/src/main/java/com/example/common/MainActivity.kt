package com.example.common

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.aidlclient.R

class MainActivity : AppCompatActivity() {

   var calc : ICommon?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onBind(view: View?){
        val intent=Intent("com.codekul.action.CALC")
        bindService(convertToImplicit(intent),object : ServiceConnection{
            override fun onServiceDisconnected(p0: ComponentName?) {
                calc=null
            }

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                calc=ICommon.Stub.asInterface(p1)
            }

        },Context.BIND_AUTO_CREATE)

    }

    fun onCalculate(view: View?){
        Log.i("@codekul","""calculation is ${calc?.calculate(15,15,'+')}""")
    }

    private fun convertToImplicit(implicitIntent:Intent):Intent?{
        val pm=packageManager
        val resolveInfo=pm.queryIntentServices(implicitIntent,0)

        if (resolveInfo==null||resolveInfo.size!=1){
            return null
        }

        val serviceInfo=resolveInfo[0]
        val packageName=serviceInfo.serviceInfo.packageName
        val className=serviceInfo.serviceInfo.name
        val component=ComponentName(packageName,className)

        val explicitIntent=Intent(implicitIntent)

        explicitIntent.component=component

        return explicitIntent
    }
}
