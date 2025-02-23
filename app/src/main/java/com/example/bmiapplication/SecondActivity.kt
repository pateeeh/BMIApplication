package com.example.bmiapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    lateinit var nameResult: TextView
    lateinit var bmiResult: TextView
    lateinit var idealStatusresult: TextView


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nameResult = findViewById(R.id.receive_nama)
        bmiResult = findViewById(R.id.bmiresult)
        idealStatusresult = findViewById(R.id.idealStatus)

        val name = intent.getStringExtra("NAME")
        val age = intent.getIntExtra("AGE",0)
        val bmi = intent.getFloatExtra("BMI", 0f)
        val idealStatus = intent.getStringExtra("IDEAL_STATUS")

        nameResult.text = "Nama: $name\nUsia: $age"
        bmiResult.text = "BMI: $bmi"
        idealStatusresult.text = "Keterangan: $idealStatus"

    }
}