package com.codekul.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        schedule()

    }

    fun schedule(){
        val compentntName = ComponentName(this,MyJobService::class.java.name)
        val jobscheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.N){
            var jobBuilder = JobInfo.Builder(123,compentntName).setMinimumLatency(5000)
            jobscheduler.schedule(jobBuilder.build())
        }
        else {
            val jobBuilder = JobInfo.Builder(123,compentntName).setPeriodic(5000)
            jobscheduler.schedule(jobBuilder.build())
        }
    }
}
