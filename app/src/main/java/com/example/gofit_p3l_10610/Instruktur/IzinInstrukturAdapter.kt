package com.example.gofit_p3l_10610.Instruktur

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.databinding.ListDataIzinInstrukturBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.shashank.sony.fancytoastlib.FancyToast

class IzinInstrukturAdapter(
    private val listIzinInstruktur: ArrayList<IzinInstruktur>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<IzinInstrukturAdapter.IzinInstrukturViewHolder>() {
    inner class IzinInstrukturViewHolder(item: ListDataIzinInstrukturBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(izinInstrukturData: IzinInstruktur) {
            with(binding) {
                txtNama.text = nama
                txtIdIzin.text = "ID Izin Instruktur: "+izinInstrukturData.ID_IZIN_INSTRUKTUR.toString()
                txtIdInstrukturPengganti.text = "Nama Instruktur Pengganti: "+izinInstrukturData.NAMA_INSTRUKTUR
                txtTanggalPengajuanIzin.text = "Tanggal Pengajuan Izin: "+izinInstrukturData.TANGGAL_PENGAJUAN_IZIN
                txtTanggalIzin.text = "Tanggal Izin: "+izinInstrukturData.TANGGAL_IZIN
                txtJamSesiIzin.text = "Jam Sesi Izin: "+izinInstrukturData.JAM_SESI_IZIN
                txtStatusKonfirmasi.text = "Status Konfirmasi: "+izinInstrukturData.STATUS_KONFIRMASI
                txtTanggalKonfirmasi.text = "Tanggal Konfirmasi: "+izinInstrukturData.TANGGAL_KONFIRMASI
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            IzinInstrukturViewHolder {
        return IzinInstrukturViewHolder(
            ListDataIzinInstrukturBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: IzinInstrukturViewHolder, position:
        Int
    ) {
        holder.bind(listIzinInstruktur[position])
    }

    override fun getItemCount() = listIzinInstruktur.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<IzinInstruktur>) {
        listIzinInstruktur.clear()
        listIzinInstruktur.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(izinInstruktur: IzinInstruktur)
        fun onUpdate(izinInstruktur: IzinInstruktur)
        fun onDelete(izinInstruktur: IzinInstruktur)
        fun onMap(izinInstruktur: IzinInstruktur)
    }
}