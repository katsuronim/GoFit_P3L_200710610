package com.example.gofit_p3l_10610.JadwalHarian

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.BookingKelasAPI.JadwalHarian
import com.example.gofit_p3l_10610.Kelas.KelasAdapter
import com.example.gofit_p3l_10610.KelasAPI.Kelas
import com.example.gofit_p3l_10610.databinding.ListDataJadwalHarianBinding
import com.example.gofit_p3l_10610.databinding.ListDataKelasBinding

class JadwalHarianAdapter (
    private val listJadwalHarian: ArrayList<com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian>,
    private val context: Context,
) :
    RecyclerView.Adapter<JadwalHarianAdapter.JadwalHarianViewHolder>() {
    inner class JadwalHarianViewHolder(item: ListDataJadwalHarianBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(jadwalHarianData: com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian) {
            with(binding) {
                txtHariTanggal.text = "Hari/Tanggal : " + jadwalHarianData.hari_jadwal_umum + " , " + jadwalHarianData.TANGGAL_JADWAL_HARIAN
                txtJamKelas.text =  "Jam Kelas : " + jadwalHarianData.jam_jadwal_umum
                txtNamaKelas.text = "Nama Kelas : " + jadwalHarianData.nama_kelas
                txtNamaInstruktur.text = "Nama Instruktur : " + jadwalHarianData.nama_instruktur
                txtStatus.text = "Catatan : " + jadwalHarianData.STATUS_JADWAL_HARIAN
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            JadwalHarianViewHolder {
        return JadwalHarianViewHolder(
            ListDataJadwalHarianBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: JadwalHarianViewHolder, position:
        Int
    ) {
        holder.bind(listJadwalHarian[position])
    }

    override fun getItemCount() = listJadwalHarian.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian>) {
        listJadwalHarian.clear()
        listJadwalHarian.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(jadwalHarian: com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian)
        fun onUpdate(jadwalHarian: com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian)
        fun onDelete(jadwalHarian: com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian)
        fun onMap(jadwalHarian: com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian)
    }
}