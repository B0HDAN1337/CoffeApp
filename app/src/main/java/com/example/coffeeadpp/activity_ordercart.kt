package com.example.coffeeadpp

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_ordercart : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ordercart)


        val backBtn: ImageButton = findViewById(R.id.backButton)

        backBtn.setOnClickListener {
            finish()
        }


    }
}