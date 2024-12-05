package com.example.vizeuygulamas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
// RecyclerView için adapter sınıfı, yemek listesi verisini görüntülemek için kullanılır.
class YemekAdapter(private val yemekList: List<Yemek>) :
    RecyclerView.Adapter<YemekAdapter.YemekViewHolder>() {

    // ViewHolder sınıfı, her bir yemek öğesinin görünümünü temsil eder
    class YemekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Yemek adı TextView'ini referans alıyoruz
        val isimTextView: TextView = itemView.findViewById(R.id.yemekIsimTextView)
    }
    // her öğe için bir görünüm oluşturur
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekViewHolder {
        //
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_yemek, parent, false)
        return YemekViewHolder(view)
    }
    //  her öğe için veriyi  bağlar
    override fun onBindViewHolder(holder: YemekViewHolder, position: Int) {
        val yemek = yemekList[position] //mevcut pozisyondaki öeyi alıyoruz
        holder.isimTextView.text = yemek.isim //yemek ismini textviewe yerleştirdim

        // Tıklama olayını ayarla
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, YemekDetayActivity::class.java).apply {
                putExtra("isim", yemek.isim)
                putExtra("malzemeler", yemek.malzemeler)
                putExtra("tarif", yemek.tarif)
            }
            context.startActivity(intent)
        }
    }
    //yemek listelendiğinde kaç öğe olduğunu gösterir
    override fun getItemCount(): Int {
        return yemekList.size
    }
}
