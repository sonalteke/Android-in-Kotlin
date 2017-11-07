package com.codekul.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService : JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.i("@codekul","OnStopJob")
        return false
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.i("@codekul","""OnStartJob Called""")
        return false
    }
}
