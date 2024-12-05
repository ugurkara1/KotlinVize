package com.example.vizeuygulamas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class YemekDetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_detay)

        val isim = intent.getStringExtra("isim")
        val malzemeler = intent.getStringExtra("malzemeler")
        val tarif = intent.getStringExtra("tarif")

        val isimTextView: TextView = findViewById(R.id.yemekDetayIsimTextView)
        val malzemelerTextView: TextView = findViewById(R.id.yemekDetayMalzemelerTextView)
        val tarifTextView: TextView = findViewById(R.id.yemekDetayTarifTextView)
        //alınan textviewleri ilgili textviewine yerleştiriyoruz
        isimTextView.text = isim
        malzemelerTextView.text = malzemeler
        tarifTextView.text = tarif
    }
}
