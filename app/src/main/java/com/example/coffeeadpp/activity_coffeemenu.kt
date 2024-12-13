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

class activity_coffeemenu : AppCompatActivity() {

    private var cartItemCount = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coffeemenu)



        val menuBtn: ImageButton = findViewById(R.id.menubutton)
        val cartCountText: TextView = findViewById(R.id.cartCount)
        val cartBtn: ImageView = findViewById(R.id.cartIcon)

        cartBtn.setOnClickListener{
            val intent = Intent(this, activity_ordercart::class.java)
            startActivity(intent)
        }

        menuBtn.setOnClickListener{
            val intent = Intent(this, activity_menubutton::class.java)
            startActivity(intent)
        }

        // Buttons to add to cart
        val espressoBtnAdd: ImageButton = findViewById(R.id.buttonEspresso)
        val doppioBtnAdd: ImageButton = findViewById(R.id.buttonDopio)
        val machiattoBtnAdd: ImageButton = findViewById(R.id.buttonMacchiato)
        val latteBtnAdd: ImageButton = findViewById(R.id.buttonLatte)
        val cappuccinoBtnAdd: ImageButton = findViewById(R.id.buttonCappuccino)
        val affogatoBtnAdd: ImageButton = findViewById(R.id.buttonAffogato)




        val buttons = listOf(espressoBtnAdd, doppioBtnAdd, machiattoBtnAdd, latteBtnAdd, cappuccinoBtnAdd, affogatoBtnAdd)
        for (button in buttons) {
            button.setOnClickListener{
                addToCart(cartCountText)
            }
            
        }

    }
    private fun addToCart(cartCountText: TextView) {
        cartItemCount++
        animateCartIcon()
        cartCountText.text = cartItemCount.toString()
    }

    private fun animateCartIcon() {
        val cartIcon: TextView = findViewById(R.id.cartCount)
        cartIcon.animate()
            .scaleX(1.2f)
            .scaleY(1.2f)
            .setDuration(100)
            .withEndAction{
                cartIcon.animate().scaleX(1f).scaleY(1f).duration = 100
            }
    }
}