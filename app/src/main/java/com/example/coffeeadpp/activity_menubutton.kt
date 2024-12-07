package com.example.coffeeadpp

import android.os.Bundle
import android.widget.ImageButton
import android.content.Intent
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_menubutton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menubutton)

        val closeBtn: ImageButton = findViewById(R.id.closeButton)
        val menuBtn: TextView = findViewById(R.id.menu)
        val aboutBtn: TextView = findViewById(R.id.about)
        val profileBtn: TextView = findViewById(R.id.profile)
        val statusBtn: TextView = findViewById(R.id.status)
        val logoutBtn: TextView = findViewById(R.id.logout)

        closeBtn.setOnClickListener{
            finish()
        }

        menuBtn.setOnClickListener{
            val intent = Intent(this, activity_coffeemenu::class.java)
            startActivity(intent)
        }

        aboutBtn.setOnClickListener{
            val intent = Intent(this, about_Activity::class.java)
            startActivity(intent)
        }

        logoutBtn.setOnClickListener{
            val sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, login_activity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

    }
}