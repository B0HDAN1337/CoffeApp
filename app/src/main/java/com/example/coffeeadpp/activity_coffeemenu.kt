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

class activity_coffeemenu : AppCompatActivity() {

    private var cartItemCount = 0
    val cartItems = mutableListOf<CartItem>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coffeemenu)


        val menuBtn: ImageButton = findViewById(R.id.menubutton)
        val cartCountText: TextView = findViewById(R.id.cartCount)
        val cartBtn: ImageView = findViewById(R.id.cartIcon)

        cartBtn.setOnClickListener {
            val intent = Intent(this, activity_ordercart::class.java)
            intent.putExtra("cartItems", ArrayList(cartItems))
            startActivity(intent)
        }

        menuBtn.setOnClickListener {
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

        espressoBtnAdd.setOnClickListener {
            addToCartCoffee("Esspresso", 3.00, cartCountText)
        }
        doppioBtnAdd.setOnClickListener {
            addToCartCoffee("Doppio", 5.00, cartCountText)
        }
        machiattoBtnAdd.setOnClickListener {
            addToCartCoffee("Machiatto", 4.50, cartCountText)
        }
        latteBtnAdd.setOnClickListener {
            addToCartCoffee("Latte", 4.50, cartCountText)
        }
        cappuccinoBtnAdd.setOnClickListener {
            addToCartCoffee("Cappuccino", 4.00, cartCountText)
        }
        affogatoBtnAdd.setOnClickListener {
            addToCartCoffee("Affogato", 5.00, cartCountText)
        }


    }

    private fun addToCartCoffee(name: String, price: Double, cartCountText: TextView) {
        cartItems.add(CartItem(name, price))
        cartItemCount++
        cartCountText.text = cartItemCount.toString()
        animateCartIcon()
        Toast.makeText(this, "$name added to cart!", Toast.LENGTH_SHORT).show()
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