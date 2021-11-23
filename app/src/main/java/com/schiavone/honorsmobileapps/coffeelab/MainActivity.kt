package com.schiavone.honorsmobileapps.coffeelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.schiavone.honorsmobileapps.coffeelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var number = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val rootView=binding.root
        setContentView(rootView)
        binding.minusButton.setOnClickListener { view ->
            updateQuantity(-1)
        }
        binding.plusButton.setOnClickListener { view ->
            updateQuantity(1)
        }
        binding.orderButton.setOnClickListener { view ->
            submitOrder()
        }
    }

    fun updateQuantity(update: Int) {
        if (number + update < 1) {
            Toast.makeText(this, R.string.toast_message1, Toast.LENGTH_LONG).show()
        } else if (number + update > 10) {
            Toast.makeText(this, R.string.toast_message2, Toast.LENGTH_LONG).show()
        } else {
            number += update
        }
        binding.quantityNumber.text = number.toString()
    }

    fun submitOrder() {

        var summary = "Thanks, ${binding.nameTop.text}!\n$number Coffees"
        var total = 0.00
        if(binding.whippedCreamBox.isChecked){
            total++
            summary += "\n+ Whipped Cream"
        }

        if(binding.chocolateBox.isChecked){
            total+=2.0
            summary += "\n+ Chocolate"
        }

        total=(5+total)*number
        summary += "\nTotal: $${total}0"
        binding.sum.text=summary
    }
}