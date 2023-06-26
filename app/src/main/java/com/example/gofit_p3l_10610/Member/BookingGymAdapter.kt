package com.example.gofit_p3l_10610.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.BookingGymAPI.BookingPresensiGym
import com.example.gofit_p3l_10610.BookingGymAPI.ClientGym
import com.example.gofit_p3l_10610.BookingGymAPI.ResponseCreateBookingPresensiGym
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateBookingKelas
import com.example.gofit_p3l_10610.databinding.ListDataBookingGymBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingGymAdapter (
    private val listBookingGym: ArrayList<BookingPresensiGym>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<BookingGymAdapter.BookingGymViewHolder>() {
    inner class BookingGymViewHolder(item: ListDataBookingGymBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(bookingGymData: BookingPresensiGym) {
            with(binding) {
                txtNama.text = nama
                txtIdMember.text = "ID Member: " + bookingGymData.ID_MEMBER
                txtNomorStruk.text = "Nomor Struk: " + bookingGymData.NOMOR_STRUK_BOOKING_PRESENSI_GYM
                txtTanggalBookingGym.text = "Tanggal Melakukan Booking: " + bookingGymData.TANGGAL_BOOKING_GYM
                txtTanggalYangDibooking.text = "Tanggal Yang Dibooking: " + bookingGymData.TANGGAL_YANG_DIBOOKING_GYM
                txtSesiDibooking.text = "Sesi Yang Dibooking: " + bookingGymData.SESI_DIBOOKING
                txtPresensi.text = "Status Presensi/Jam Presensi: " + bookingGymData.STATUS_PRESENSI_GYM + " / " + bookingGymData.JAM_PRESENSI_GYM
                btnDelete.setOnClickListener {
                    val call: Call<ResponseCreateBookingPresensiGym> = ClientGym.apiService.deleteData(bookingGymData.NOMOR_STRUK_BOOKING_PRESENSI_GYM)
                    call?.enqueue(object : Callback<ResponseCreateBookingPresensiGym?> {
                        override fun onResponse(call: Call<ResponseCreateBookingPresensiGym?>, response: Response<ResponseCreateBookingPresensiGym?>) {
                            if(response != null){
                                if(response.body()?.stt != true){
                                    FancyToast.makeText(context, response.body()?.message.toString(),
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.INFO,true).show()
                                } else {
                                    FancyToast.makeText(context, response.body()?.message.toString() + " - " + bookingGymData.NOMOR_STRUK_BOOKING_PRESENSI_GYM,
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.SUCCESS,true).show()
                                    notifyDataSetChanged()
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseCreateBookingPresensiGym?>, t: Throwable) {
                            FancyToast.makeText(context, t.message,
                                FancyToast.LENGTH_LONG,
                                FancyToast.ERROR,true).show()
                        }
                    })
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BookingGymViewHolder {
        return BookingGymViewHolder(
            ListDataBookingGymBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BookingGymViewHolder, position:
        Int
    ) {
        holder.bind(listBookingGym[position])
    }

    override fun getItemCount() = listBookingGym.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingPresensiGym>) {
        listBookingGym.clear()
        listBookingGym.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(bookingGymData: BookingPresensiGym)
        fun onUpdate(bookingGymData: BookingPresensiGym)
        fun onDelete(bookingGymData: BookingPresensiGym)
        fun onMap(bookingGymData: BookingPresensiGym)
    }
}