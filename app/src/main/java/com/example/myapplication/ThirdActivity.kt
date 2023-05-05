package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_screen_layout)

        val thirdButton = findViewById<Button>(R.id.screenThreeButton)

        thirdButton.setOnClickListener {
            finish()

        }

    }

}