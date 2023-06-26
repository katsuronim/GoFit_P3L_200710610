package com.example.gofit_p3l_10610.Instruktur

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.HistoriInstruktur
import com.example.gofit_p3l_10610.databinding.ListDataHistoriInstrukturBinding
import com.example.gofit_p3l_10610.databinding.ListDataIzinInstrukturBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur

class HistoriInstrukturAdapter (
    private val listHistori: ArrayList<HistoriInstruktur>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<HistoriInstrukturAdapter.HistoriInstrukturViewHolder>() {
    inner class HistoriInstrukturViewHolder(item: ListDataHistoriInstrukturBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(historiData: HistoriInstruktur) {
            with(binding) {
                txtNama.text = "Nama Kelas: " + historiData.NAMA_KELAS
                txtHariTanggal.text = "Hari/Tanggal: "+historiData.HARI_JADWAL_UMUM +" / "+historiData.TANGGAL_JADWAL_HARIAN
                txtJamMulai.text = "Jam Mulai Kelas: "+historiData.JAM_MULAI
                txtJamSelesai.text = "Jam Selesai Kelas: "+historiData.JAM_SELESAI
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoriInstrukturViewHolder {
        return HistoriInstrukturViewHolder(
            ListDataHistoriInstrukturBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: HistoriInstrukturViewHolder, position:
        Int
    ) {
        holder.bind(listHistori[position])
    }

    override fun getItemCount() = listHistori.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<HistoriInstruktur>) {
        listHistori.clear()
        listHistori.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(historiInstruktur: HistoriInstruktur)
        fun onUpdate(historiInstruktur: HistoriInstruktur)
        fun onDelete(historiInstruktur: HistoriInstruktur)
        fun onMap(historiInstruktur: HistoriInstruktur)
    }
}