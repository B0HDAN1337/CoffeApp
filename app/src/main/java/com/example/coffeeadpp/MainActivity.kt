package com.example.coffeeadpp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val loginBtn: Button = findViewById(R.id.loginButton)
        val regBtn: TextView = findViewById(R.id.registerButton)

        loginBtn.setOnClickListener{
            val intent = Intent(this, login_activity::class.java)
            startActivity(intent)
        }

        regBtn.setOnClickListener{
            val intent = Intent(this, register_activity::class.java)
            startActivity(intent)
        }
    }
}