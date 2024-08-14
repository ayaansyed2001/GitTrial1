package com.example.gittrial

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private var num1: EditText? = null
    private var num2: EditText? = null
    private var resulttv: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        resulttv = findViewById(R.id.result)

        val multiplication = findViewById<Button>(R.id.multiplication)
        multiplication.setOnClickListener { performCalculation('*') }
        val division = findViewById<Button>(R.id.division)
        division.setOnClickListener { performCalculation('/') }

    }

    private fun performCalculation(operator: Char) {
        val num1Str = num1!!.text.toString()
        val num2Str = num2!!.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "please enter both numbers", Toast.LENGTH_SHORT).show()
            return

        }
        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        var result = 0.0
        when (operator) {
            '+' -> result = num1 + num2
            '-' -> result = num1 - num2
            '*' -> result = num1 * num2
            '/' -> result = if (num2 != 0.0) {
                num1 / num2
            } else {
                Toast.makeText(this, "cannot divide by zero", Toast.LENGTH_SHORT).show()
                return

            }
        }
        val df = DecimalFormat("#.##")
        resulttv!!.text = "Result" + df.format(result)
    }

    @SuppressLint("SetTextI18n")
    private fun calculateSquareRoot() {
        val num1str = num1!!.text.toString()
        if (num1str.isEmpty()) {
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show()
            return
        }

        val num = num1str.toDouble()
        val sqrtResult = Math.sqrt(num)
        val df = DecimalFormat("#.##")
        resulttv!!.text = "SquareRoot:" + df.format(sqrtResult)

    }
}