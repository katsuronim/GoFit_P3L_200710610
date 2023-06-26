package com.example.gofit_p3l_10610.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateBookingKelas
import com.example.gofit_p3l_10610.databinding.ListDataBookingKelasBinding
import com.example.gofit_p3l_10610.databinding.ListDataPaketBinding
import com.example.gofit_p3l_10610.userAPI.DepositKelasMember
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DepositKelasMemberAdapter(
    private val listPaket: ArrayList<DepositKelasMember>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<DepositKelasMemberAdapter.DepositKelasMemberViewHolder>() {
    inner class DepositKelasMemberViewHolder(item: ListDataPaketBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(paketData: DepositKelasMember) {
            with(binding) {
                txtNama.text = "Nama Kelas: " + paketData.NAMA_KELAS
                txtKadaluarsa.text = "Tanggal Kadaluarsa: " + paketData.TANGGAL_KADALUARSA
                txtDeposit.text = "Jumlah Deposit Paket: " + paketData.DEPOSIT_PAKET_KELAS
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            DepositKelasMemberViewHolder {
        return DepositKelasMemberViewHolder(
            ListDataPaketBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: DepositKelasMemberViewHolder, position:
        Int
    ) {
        holder.bind(listPaket[position])
    }

    override fun getItemCount() = listPaket.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<DepositKelasMember>) {
        listPaket.clear()
        listPaket.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(paket: DepositKelasMember)
        fun onUpdate(paket: DepositKelasMember)
        fun onDelete(paket: DepositKelasMember)
        fun onMap(paket: DepositKelasMember)
    }
}