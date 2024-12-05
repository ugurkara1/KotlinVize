package com.example.vizeuygulamas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    companion object {
        val sabitYemekler = listOf(
            //3 tane yemek tanımladım
            Yemek(
                "Boyoz",
                "Un, Tuz, Su, Tahin, Tereyağı, Susam",
                "Unu geniş bir kaba alın, tuzu ekleyin. Yavaş yavaş su ekleyerek ele yapışmayan, yumuşak bir hamur yoğurun. Hamuru 6-7 eşit bezeye ayırın. Bezeleri streç filmle kapatarak en az 30 dakika dinlendirin. Dinlenen bezeleri un yardımıyla açabildiğiniz kadar ince açın. Açılan hamuru eritilmiş tereyağı ve tahin karışımıyla fırçalayarak yağlayın. Hamuru rulo şeklinde sarıp kendi etrafında dolayarak bir halka oluşturun. Şekil verilen hamurları tekrar 15-20 dakika dinlendirin. Yağlı kağıt serili tepsiye dizin. Üzerlerine susam serpin. Önceden ısıtılmış 200°C fırında üzeri kızarana kadar (yaklaşık 20-25 dakika) pişirin."
            ),
            Yemek(
                "Kumru",
                "Sandviç Ekmeği, Sucuk, Salam, Kaşar Peyniri, Domates, Turşu",
                "Sandviç ekmeğini ortadan kesin ve içerisine sucuk, salam ve kaşar peyniri ekleyin. İsteğe bağlı olarak domates ve turşu dilimleriyle lezzetlendirin. Kumruyu ızgarada ya da tost makinesinde pişirerek sıcak olarak servis edin."
            ),
            Yemek(
                "Lokma",
                "Un, Su, Maya, Şeker, Yağ",
                "Un, su ve mayayı karıştırarak yumuşak bir hamur elde edin. Hamuru mayalanması için yaklaşık 30 dakika bekletin. Mayalanan hamuru yuvarlak toplar halinde şekillendirip kızgın yağda kızartın. Kızaran lokmaları şerbetle buluşturarak tatlıyı servis edin."
            )
        )
        //yemek listesi oluşturdum gerekli eklemeleri yapsın
        val yemekListesi: MutableList<Yemek> = mutableListOf()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //kalıcı yemekleri listeleye ekle
        yemekListesi.addAll(sabitYemekler)


        // Toolbar'ı ayarla
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Sayaç için TextView
        val sayacTextView: TextView = findViewById(R.id.sayacTextView)

        // 5 saniyelik geri sayım
        val timer = object : CountDownTimer(5000, 1000) {
            @SuppressLint("SetTextI18n")
            //her saniyede bir tetiklenir
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                sayacTextView.text = "Giriş ekranına yönlendiriliyor: $secondsLeft"
            }
            //sayaç tamamlandığında çalışacak kısım
            override fun onFinish() {
                //LoginActivity ekranına geçiş
                val intent = Intent(this@MainActivity, LoginActivity::class.java) //ıntent ile iletişim kurmak için
                startActivity(intent)
                // MainActivity'yi kapatıyoruz, geri tuşuna basıldığında bu ekran açılmaz
                finish() // Bu aktiviteyi kapatır
            }
        }
        // Sayaç başlatılıyor

        timer.start()


    }

}