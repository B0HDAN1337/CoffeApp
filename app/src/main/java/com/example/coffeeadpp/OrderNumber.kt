package com.example.coffeeadpp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import kotlin.random.Random
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.Button

class OrderNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ordernumber)

        val lobster = ResourcesCompat.getFont(this, R.font.lobster)

        val time: TextView  = findViewById(R.id.dynamicTime)
        val timeToCoffeeOrderDone = getRandomTime()
        val spannable = SpannableString("Time: $timeToCoffeeOrderDone minutes")
        spannable.setSpan(StyleSpan(Typeface.NORMAL), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 6, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        time.text = spannable


        val order: TextView = findViewById(R.id.orderNumber)
        val orderNumberRandom = getRandomOrder()
        order.text = "$orderNumberRandom"



        val buttonConf: Button = findViewById(R.id.buttonOrder)
        buttonConf.setOnClickListener{
            val intent = Intent(this, activity_coffeemenu::class.java)
            startActivity(intent)
        }

    }

    fun getRandomTime(): Int{
        return Random.nextInt(5,12)
    }

    fun getRandomOrder(): String{
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val randomCode = StringBuilder("#")
        repeat(10){
            randomCode.append(chars.random())
        }
        return randomCode.toString()
    }
}