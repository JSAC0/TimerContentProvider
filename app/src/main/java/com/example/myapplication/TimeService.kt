package com.example.myapplication

import android.app.Service
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class TimeService : Service() {

    private var startTime: Long = 0


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         startTime = (SystemClock.elapsedRealtime()) / 1000
         Log.d("appmine", "inicio: $startTime")
         return super.onStartCommand(intent, flags, startId)

     }

    override fun onDestroy() {
        super.onDestroy()
        val endTime = (SystemClock.elapsedRealtime()) / 1000
        Log.d("appmine", "actual: $endTime")
        val elapsedTime = endTime - startTime
        Log.d("appmine", "laresta: $elapsedTime")

        val contentValues = ContentValues()
        contentValues.put("time", elapsedTime)
        Log.d("appone", "fintime:$contentValues")
        contentResolver.insert(Uri.parse("content://com.example.myapplication.timeprovider/time"), contentValues)
        Log.d("appone", "finjassir:$contentValues")


    }
}

