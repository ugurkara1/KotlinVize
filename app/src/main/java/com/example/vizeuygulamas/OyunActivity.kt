package com.example.vizeuygulamas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OyunActivity : AppCompatActivity() {

    private val kelimeler = listOf("elma", "armut", "muz", "kiraz", "karpuz","kavun","hurma","nar") // kelimeleri liste halinde tanımladım
    private var currentWord = "" //mevcut kelime için değişken ataması
    private var score = 0 //skor değeri

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun)//xml kısmını set ettim
        //xml kısmıyla bağlama
        val wordTextView: TextView = findViewById(R.id.wordTextView) //gelen kelime
        val inputEditText: EditText = findViewById(R.id.inputEditText) //girilecek kelime
        val scoreTextView: TextView = findViewById(R.id.scoreTextView) //skor değeri
        val submitButton: Button = findViewById(R.id.submitButton) //girilen kelimeyi gönder

        // İlk kelimeyi karıştır ve göster
        showNewWord(wordTextView)

        submitButton.setOnClickListener {
            val userInput = inputEditText.text.toString().trim() //girilen değerin boşluklarını alıp tutma
            if (userInput == currentWord) { //mevcut kelime ve kullanıcının girdiği kelime doğruysa
                score += 10
                scoreTextView.text = "Puan: $score"
                Toast.makeText(this, "Doğru Cevap! 10 Puan Kazandınız.", Toast.LENGTH_SHORT).show()
                inputEditText.text.clear()
                showNewWord(wordTextView)
            } else {
                Toast.makeText(this, "Yanlış Cevap. Tekrar deneyin.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showNewWord(wordTextView: TextView) {
        // Kelimeyi karıştır
        currentWord = kelimeler.random()
        //kelimeyi listeye dönüştürdüm ve her harf bir liste elemanı oldu //shuffled ile karıştırdım //joinToString ile karıştırılmış ifadeyi tek string haline getirdim
        val shuffledWord = currentWord.toList().shuffled().joinToString("")
        wordTextView.text = "Kelimeyi bul: $shuffledWord" //karıştırılmış kelimeyi atadım
    }
}
