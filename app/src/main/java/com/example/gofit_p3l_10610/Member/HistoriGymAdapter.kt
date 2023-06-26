package com.example.gofit_p3l_10610.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.BookingGymAPI.BookingPresensiGym
import com.example.gofit_p3l_10610.databinding.ListDataHistoriGymBinding
import com.example.gofit_p3l_10610.databinding.ListDataPaketBinding
import com.example.gofit_p3l_10610.userAPI.DepositKelasMember

class HistoriGymAdapter (
    private val listHistoriGym: ArrayList<BookingPresensiGym>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<HistoriGymAdapter.HistoriGymViewHolder>() {
    inner class HistoriGymViewHolder(item: ListDataHistoriGymBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(historiData: BookingPresensiGym) {
            with(binding) {
                txtNomorStruk.text = "Nomor Struk: " + historiData.NOMOR_STRUK_BOOKING_PRESENSI_GYM
                txtTanggalBooking.text = "Tanggal Melakukan Booking: " + historiData.TANGGAL_BOOKING_GYM
                txtTanggalHadirGym.text = "Tanggal Hadir di Gym: " + historiData.TANGGAL_YANG_DIBOOKING_GYM
                txtSesi.text = "Sesi Gym: " + historiData.SESI_DIBOOKING
                txtStatus.text = "Status Presensi: " + historiData.STATUS_PRESENSI_GYM
                txtJamPresensi.text = "Jam Presensi: " + historiData.JAM_PRESENSI_GYM
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoriGymViewHolder {
        return HistoriGymViewHolder(
            ListDataHistoriGymBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: HistoriGymViewHolder, position:
        Int
    ) {
        holder.bind(listHistoriGym[position])
    }

    override fun getItemCount() = listHistoriGym.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingPresensiGym>) {
        listHistoriGym.clear()
        listHistoriGym.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(historyGym: BookingPresensiGym)
        fun onUpdate(historyGym: BookingPresensiGym)
        fun onDelete(historyGym: BookingPresensiGym)
        fun onMap(historyGym: BookingPresensiGym)
    }
}