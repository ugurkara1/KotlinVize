package com.example.vizeuygulamas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class YemekEkleActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_ekle)

        val isimInput: EditText = findViewById(R.id.yemekIsimInput)
        val malzemelerInput: EditText = findViewById(R.id.yemekMalzemelerInput)
        val tarifInput: EditText = findViewById(R.id.yemekTarifInput)
        val ekleButton: Button = findViewById(R.id.yemekEkleButton)

        ekleButton.setOnClickListener {
            val isim = isimInput.text.toString()
            val malzemeler = malzemelerInput.text.toString()
            val tarif = tarifInput.text.toString()

            if (isim.isNotEmpty() && malzemeler.isNotEmpty() && tarif.isNotEmpty()) {
                MainActivity.yemekListesi.add(Yemek(isim, malzemeler, tarif))
                finish() // Aktiviteyi kapat
            }
        }
    }
}