package com.example.gofit_p3l_10610.Kelas

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.Instruktur.IzinInstrukturAdapter
import com.example.gofit_p3l_10610.KelasAPI.Kelas
import com.example.gofit_p3l_10610.databinding.ListDataIzinInstrukturBinding
import com.example.gofit_p3l_10610.databinding.ListDataKelasBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur

class KelasAdapter (
    private val listKelas: ArrayList<Kelas>,
    private val context: Context,
) :
    RecyclerView.Adapter<KelasAdapter.KelasViewHolder>() {
    inner class KelasViewHolder(item: ListDataKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(kelasData: Kelas) {
            with(binding) {
                txtNama.text = "Nama Kelas : " + kelasData.NAMA_KELAS
                txtHarga.text =  "Harga Kelas : " + kelasData.HARGA_KELAS
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            KelasViewHolder {
        return KelasViewHolder(
            ListDataKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: KelasViewHolder, position:
        Int
    ) {
        holder.bind(listKelas[position])
    }

    override fun getItemCount() = listKelas.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<Kelas>) {
        listKelas.clear()
        listKelas.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(kelas: Kelas)
        fun onUpdate(kelas: Kelas)
        fun onDelete(kelas: Kelas)
        fun onMap(kelas: Kelas)
    }
}