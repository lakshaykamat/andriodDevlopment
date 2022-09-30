package com.lakshaykamat.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num = findViewById<TextView>(R.id.num);
        val incrementButton = findViewById<Button>(R.id.increment)
        val decrementButton = findViewById<Button>(R.id.decrement)
        val saveButton = findViewById<Button>(R.id.savebtn)
        val saveTxt = findViewById<TextView>(R.id.saved);
        var number = 0;
        var str = "Save: "
        num.text = number.toString()

        incrementButton.setOnClickListener{
            number++
            num.text = number.toString()
        }

        decrementButton.setOnClickListener{
            number--
            num.text = number.toString()
        }

        saveButton.setOnClickListener {
            str += number.toString() + " - "
            saveTxt.text = str;
        }
    }
}