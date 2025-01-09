package com.example.basic_calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMulti: Button
    lateinit var btnDiv: Button
    lateinit var num1 : EditText
    lateinit var num2 : EditText
    lateinit var resultTv : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMulti = findViewById(R.id.btnMulti)
        btnDiv = findViewById(R.id.btnDiv)
        num1 = findViewById(R.id.etNum1)
        num2 = findViewById(R.id.etNum2)
        resultTv = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMulti.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var a = num1.text.toString().toDouble()
        var b = num2.text.toString().toDouble()
        var result = 0.0

        when (v?.id)
        {
            R.id.btnAdd -> {
                result = a + b
            }
            R.id.btnSub -> {
                result = a - b
            }
            R.id.btnDiv -> {
                result = a / b
            }
            R.id.btnMulti -> {
                result = a * b
            }
        }

        resultTv.text = "Result is $result"
    }
}