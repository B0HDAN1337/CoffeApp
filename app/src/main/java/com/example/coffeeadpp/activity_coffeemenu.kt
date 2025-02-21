package com.example.coffeeadpp

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class activity_coffeemenu : AppCompatActivity(), OnItemClickListener {

    private var cartItemCount = 0
    val cartItems = mutableListOf<CartItem>()
    private lateinit var cartCountText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coffeemenu)


        val menuBtn: ImageButton = findViewById(R.id.menubutton)
        cartCountText = findViewById(R.id.cartCount)
        val cartBtn: ImageView = findViewById(R.id.cartIcon)


        val dataItem = mutableListOf(
            CartItem("Espresso", 3.00, "Single shot Espresso"),
            CartItem("Doppio", 5.00, "Double shot Espresso"),
            CartItem("Macchiato", 4.50, "Espresso with a dollop of milk"),
            CartItem("Cafe Lattee", 4.50, "Espresso with steamed milk and foam"),
            CartItem("Cappuccino", 4.00, "Short size latte"),
            CartItem("Affogato", 5.00, "Esspresso with vanilla ice-cream")
        )

        val adapterItem = AdapterItem(dataItem, this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterItem

        cartBtn.setOnClickListener {
            val intent = Intent(this, activity_ordercart::class.java)
            intent.putExtra("cartItems", ArrayList(cartItems))
            startActivity(intent)
        }

        menuBtn.setOnClickListener {
            val intent = Intent(this, activity_menubutton::class.java)
            startActivity(intent)
        }
    }

    override fun onAddToCartClick(item: CartItem) {
        cartItems.add(item)
        cartItemCount++
        cartCountText.text = cartItemCount.toString()
        animateCartIcon()
    }

    private fun animateCartIcon() {
        val cartIcon: TextView = findViewById(R.id.cartCount)
        cartIcon.animate()
            .scaleX(1.2f)
            .scaleY(1.2f)
            .setDuration(100)
            .withEndAction {
                cartIcon.animate().scaleX(1f).scaleY(1f).duration = 100
            }
    }
}