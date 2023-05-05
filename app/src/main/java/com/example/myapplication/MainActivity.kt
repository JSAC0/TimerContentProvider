package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService(Intent(this, TimeService::class.java))

        val firstButton = findViewById<Button>(R.id.screenOneButton)

        firstButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java )
            startActivity(intent)

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, TimeService::class.java))

    }
}