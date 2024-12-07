package com.example.coffeeadpp

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class about_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        val closeBtn: ImageButton = findViewById(R.id.aboutmenubbutton)

        closeBtn.setOnClickListener{
            val intent = Intent(this, activity_menubutton::class.java)
            startActivity(intent)
        }
    }
}