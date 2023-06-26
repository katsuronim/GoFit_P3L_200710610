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
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingKelasAdapter(
    private val listBookingKelas: ArrayList<BookingKelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<BookingKelasAdapter.BookingKelasViewHolder>() {
    inner class BookingKelasViewHolder(item: ListDataBookingKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(bookingKelasData: BookingKelas) {
            with(binding) {
                txtNama.text = nama
                txtNomorStruk.text = "Nomor Struk: "+ bookingKelasData.NOMOR_STRUK.toString()
                txtIdJadwalHarian.text = "ID Jadwal Harian: "+ bookingKelasData.ID_JADWAL_HARIAN
                txtTanggalBookingKelas.text = "Tanggal Booking Kelas: "+ bookingKelasData.TANGGAL_BOOKING_KELAS
                txtNamaKelas.text = "Nama Kelas : "+bookingKelasData.NAMA_KELAS
                txtHariJadwalHarian.text = "Hari/Tanggal Kelas : " +bookingKelasData.HARI_JADWAL_UMUM + " / " + bookingKelasData.TANGGAL_JADWAL_HARIAN
                txtTanggalPresensiKelas.text = "Status/Jam Presensi : " +bookingKelasData.STATUS_PRESENSI_KELAS + " / " + bookingKelasData.JAM_PRESENSI_KELAS
                btnDelete.setOnClickListener {
                    val call: Call<ResponseCreateBookingKelas> = ClientBookingKelas.apiService.deleteData(bookingKelasData.NOMOR_STRUK)
                    call?.enqueue(object : Callback<ResponseCreateBookingKelas?> {
                        override fun onResponse(call: Call<ResponseCreateBookingKelas?>, response: Response<ResponseCreateBookingKelas?>) {
                            if(response != null){
                                if(response.body()?.stt != true){
                                    FancyToast.makeText(context, response.body()?.message.toString(),
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.INFO,true).show()
                                } else {
                                    FancyToast.makeText(context, response.body()?.message.toString() + " - " + bookingKelasData.NOMOR_STRUK,
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.SUCCESS,true).show()
                                    notifyDataSetChanged()
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseCreateBookingKelas?>, t: Throwable) {
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
            BookingKelasViewHolder {
        return BookingKelasViewHolder(
            ListDataBookingKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BookingKelasViewHolder, position:
        Int
    ) {
        holder.bind(listBookingKelas[position])
    }

    override fun getItemCount() = listBookingKelas.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingKelas>) {
        listBookingKelas.clear()
        listBookingKelas.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(bookingKelas: BookingKelas)
        fun onUpdate(bookingKelas: BookingKelas)
        fun onDelete(bookingKelas: BookingKelas)
        fun onMap(bookingKelas: BookingKelas)
    }
}