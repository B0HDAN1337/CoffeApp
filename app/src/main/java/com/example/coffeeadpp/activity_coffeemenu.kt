package com.example.coffeeadpp

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_coffeemenu : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coffeemenu)

        val menuBtn: ImageButton = findViewById(R.id.menubutton)

        menuBtn.setOnClickListener{
            val intent = Intent(this, activity_menubutton::class.java)
            startActivity(intent)
        }


    }
}