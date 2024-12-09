package com.example.coffeeadpp

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


class register_activity : AppCompatActivity() {

    private lateinit var dbHelper : DataBaseHelper
    private fun areFieldsEmpty(vararg fields: String): Boolean {
        return fields.any { it.isEmpty() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val registerBtn : Button = findViewById(R.id.buttonCreateRegister)
        val nameRegisterText : EditText = findViewById(R.id.nameRegisterInput)
        val emailRegisterText : EditText = findViewById(R.id.emailRegisterInput)
        val passwordRegisterText : EditText = findViewById(R.id.passwordRegisterInput)
        val passwordConfText : EditText = findViewById(R.id.confirmInput)
        val loginBtn : TextView = findViewById(R.id.loginInText)

        loginBtn.setOnClickListener{
            val intent = Intent(this, login_activity::class.java)
            startActivity(intent)
        }

        dbHelper = DataBaseHelper(this)

        registerBtn.setOnClickListener{
            val name = nameRegisterText.text.toString()
            val email = emailRegisterText.text.toString()
            val password = passwordRegisterText.text.toString()
            val confirmPassword = passwordConfText.text.toString()

            if (areFieldsEmpty(name, email, password, confirmPassword)){
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do mot match", Toast.LENGTH_SHORT).show()
            } else {
                val result = dbHelper.registerUser(name, email, password)
                if (result > 0) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, login_activity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}