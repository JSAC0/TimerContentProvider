package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen_layout)

        val secondButton = findViewById<Button>(R.id.screenTwoButton)

        secondButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java )
            startActivity(intent)

        }

    }
}