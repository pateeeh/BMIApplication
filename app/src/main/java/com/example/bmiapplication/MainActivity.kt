package com.example.bmiapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nama: EditText = findViewById(R.id.edit_nama)
        val usia: EditText = findViewById(R.id.edit_usia)
        val berat: EditText = findViewById(R.id.edit_berat)
        val tinggi: EditText = findViewById(R.id.edit_tinggi)
        val btnHitung: Button = findViewById(R.id.hasil_hitung)

        btnHitung.setOnClickListener{
            val inputnama = nama.text.toString().trim()
            val inputusia = usia.text.toString().trim()
            val inputberat = berat.text.toString().trim()
            val inputtinggi = tinggi.text.toString().trim()

            var isEmptyField = false

            if (inputnama.isEmpty()){
                isEmptyField = true
                nama.error = "Field ini tidak boleh kosong"
            }
            if (inputusia.isEmpty()){
                isEmptyField = true
                usia.error = "Field ini tidak boleh kosong"
            }
            if (inputberat.isEmpty()){
                isEmptyField = true
                berat.error = "Field ini tidak boleh kosong"
            }
            if (inputtinggi.isEmpty()){
                isEmptyField = true
                tinggi.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                val result = inputberat.toDouble() / (inputtinggi.toDouble() * inputtinggi.toDouble())
                val idealStatus = when {
                    result < 18.5 -> "Tidak Ideal (Underweight)"
                    result in 18.5..24.9 -> "Ideal"
                    result in 25.0..29.9 -> "Tidak Ideal (Overweight)"
                    else -> "Tidak Ideal (Obesitas)"
                }
                result.toString()


                val moveIntent = Intent(this@MainActivity, SecondActivity::class.java)
                moveIntent.putExtra("NAME", inputnama)
                moveIntent.putExtra("AGE", inputusia)
                moveIntent.putExtra("BMI", result)
                moveIntent.putExtra("IDEAL_STATUS", idealStatus)
                startActivity(moveIntent)
            }

        }


    }
}