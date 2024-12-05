package com.example.vizeuygulamas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class YemekListActivity : AppCompatActivity() {

    private lateinit var yemekAdapter: YemekAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_list)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView: RecyclerView = findViewById(R.id.yemekRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        yemekAdapter = YemekAdapter(MainActivity.yemekListesi)
        recyclerView.adapter = yemekAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_yemek_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add_yemek -> {
                val intent = Intent(this, YemekEkleActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.oyun -> {
                // Oyun ekranına geçiş
                val intent = Intent(this, OyunActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // LoginActivity'ye geri dön ve bayrak gönder
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("isComingBack", true) // Geri dönüş bayrağı
        startActivity(intent)
        finish()
    }
}
