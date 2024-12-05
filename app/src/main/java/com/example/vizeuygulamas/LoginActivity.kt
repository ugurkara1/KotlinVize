package com.example.vizeuygulamas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    // SharedPreferences ve Editor nesnelerini tanımladım

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    // SharedPreferences için bir isim belirledim
    private val PREFS_NAME = "LoginPrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //gerekli bağlamaları yaptım
        val KullaniciInput: EditText = findViewById(R.id.KullaniciInput)
        val PasswordInput: EditText = findViewById(R.id.PasswordInput)
        val rememberCheckBox: CheckBox = findViewById(R.id.rememberCheckBox)

        // SharedPreferences başlat
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        // "Beni Hatırla" seçeneği işaretliyse bilgileri doldur
        if (sharedPreferences.getBoolean("remember", false)) {
            KullaniciInput.setText(sharedPreferences.getString("username", ""))
            PasswordInput.setText(sharedPreferences.getString("password", ""))
            rememberCheckBox.isChecked = true
        }

        // Giriş butonu
        findViewById<Button>(R.id.girisButton).setOnClickListener {
            val username = KullaniciInput.text.toString()
            val password = PasswordInput.text.toString()

            if (username == "ugur" && password == "123") {
                if (rememberCheckBox.isChecked) {
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.putBoolean("remember", true)
                } else {
                    editor.remove("username")
                    editor.remove("password")
                    editor.putBoolean("remember", false)
                }
                editor.apply() //değişiklikleri uygula
                //giriş yaptıktan sonra yemek listeleme kısmına atması için intent ile iletişimi sağladım
                val intent = Intent(this, YemekListActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Hatalı Kullanıcı Adı veya Şifre", Toast.LENGTH_SHORT).show()
            }
        }
    }
    //giriş alanına geri dönüldüğünde,ınput alanını sıfırlamak için yazdığım fonksiyon
    override fun onResume() {
        super.onResume()

        val KullaniciInput: EditText = findViewById(R.id.KullaniciInput)
        val PasswordInput: EditText = findViewById(R.id.PasswordInput)
        val rememberCheckBox: CheckBox = findViewById(R.id.rememberCheckBox)

        // Intent ile geri dönüldüyse alanları temizle
        val isComingBack = intent.getBooleanExtra("isComingBack", false)
        if (isComingBack) {
            KullaniciInput.setText("") // Alanları temizlemek için boş metin ata
            PasswordInput.setText("") // Alanları temizlemek için boş metin ata
            rememberCheckBox.isChecked = sharedPreferences.getBoolean("remember", false)
        }
    }
}
