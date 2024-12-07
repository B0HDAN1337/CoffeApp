package com.example.coffeeadpp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.typeOf


class login_activity : AppCompatActivity() {

    private lateinit var dbHelper: DataBaseHelper

    private fun areFieldsEmpty(vararg fields: String): Boolean {
        return fields.any { it.isEmpty() }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val inputPsw: EditText = findViewById(R.id.inputPsw)
        val emailInpt: EditText = findViewById(R.id.inputE)
        val loginBtn: Button = findViewById(R.id.loginButton)
        val registerBtn: TextView = findViewById(R.id.registerText)

        dbHelper = DataBaseHelper(this)

        registerBtn.setOnClickListener{
            val intent = Intent(this, register_activity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener{
            val password = inputPsw.text.toString()
            val email = emailInpt.text.toString()

            if (areFieldsEmpty(email, password)) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else if (dbHelper.loginUser(email, password)) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, activity_coffeemenu::class.java)
                startActivity(intent)

                val sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }

        }



    }
}