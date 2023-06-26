package com.example.gofit_p3l_10610.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.databinding.ListDataHistoriGymBinding
import com.example.gofit_p3l_10610.databinding.ListDataHistoryKelasBinding

class HistoryKelasAdapter(
    private val listHistoriKelas: ArrayList<BookingKelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<HistoryKelasAdapter.HistoriKelasViewHolder>() {
    inner class HistoriKelasViewHolder(item: ListDataHistoryKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(historiData: BookingKelas) {
            with(binding) {
                txtNomorStruk.text = "Nomor Struk: " + historiData.NOMOR_STRUK
                txtNamaKelas.text = "Kelas: " + historiData.NAMA_KELAS
                txtTanggalBooking.text = "Tanggal Melakukan Booking: " + historiData.TANGGAL_BOOKING_KELAS
                txtHariTanggal.text = "Hari/Tanggal Kelas: " + historiData.HARI_JADWAL_UMUM + " / " + historiData.TANGGAL_JADWAL_HARIAN
                txtJenisBooking.text = "Jenis Booking: " + historiData.JENIS_BOOKING_PRESENSI
                txtStatus.text = "Status Presensi: " + historiData.STATUS_PRESENSI_KELAS
                txtJamPresensi.text = "Jam Presensi: " + historiData.JAM_PRESENSI_KELAS
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoriKelasViewHolder {
        return HistoriKelasViewHolder(
            ListDataHistoryKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: HistoriKelasViewHolder, position:
        Int
    ) {
        holder.bind(listHistoriKelas[position])
    }

    override fun getItemCount() = listHistoriKelas.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingKelas>) {
        listHistoriKelas.clear()
        listHistoriKelas.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(historyKelas: BookingKelas)
        fun onUpdate(historyKelas: BookingKelas)
        fun onDelete(historyKelas: BookingKelas)
        fun onMap(historyKelas: BookingKelas)
    }
}