package com.example.coffeeadpp

import android.annotation.SuppressLint
import android.os.Bundle
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import android.content.Intent
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
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

        val lobster = ResourcesCompat.getFont(this, R.font.lobster)


        val cartItems = intent.getSerializableExtra("cartItems") as ArrayList<CartItem>
        val cartItemsLayout: LinearLayout = findViewById(R.id.cartItems)
        val backBtn: ImageButton = findViewById(R.id.backButton)
        val totalPriceView: TextView = findViewById(R.id.totalPrice)

        backBtn.setOnClickListener {
            finish()
        }

        var totalPrice: Double = 0.0

        cartItems?.forEach { item ->
            val itemTextView = TextView(this)
            itemTextView.text = "${item.name}............. \$${"%.2f".format(item.price)}"
            itemTextView.textSize = 30f
            itemTextView.setTypeface(lobster, Typeface.BOLD_ITALIC)
            cartItemsLayout.addView(itemTextView)
            totalPrice += item.price
        }

        totalPriceView.text = "Total \$${"%.2f".format(totalPrice)}"



    }
}