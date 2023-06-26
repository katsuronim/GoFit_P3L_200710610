package com.example.gofit_p3l_10610.Instruktur

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateJadwalHarian
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ClientPresensiInstruktur
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ResponseCreatePresensiInstruktur
import com.example.gofit_p3l_10610.databinding.ListDataBookingKelasBinding
import com.example.gofit_p3l_10610.databinding.ListDataBookingPresensiKelasBinding
import com.example.gofit_p3l_10610.databinding.ListDataIzinInstrukturBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingPresensiKelasAdapter(
    private val listBookingKelas: ArrayList<BookingKelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<BookingPresensiKelasAdapter.BookingPresensiKelasViewHolder>() {
    inner class BookingPresensiKelasViewHolder(item: ListDataBookingPresensiKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(bookingKelasData: BookingKelas) {
            with(binding) {
                txtNama.text = bookingKelasData.NAMA_KELAS
                txtNamaMember.text = bookingKelasData.ID_MEMBER + " / " + bookingKelasData.NAMA_MEMBER
                txtTanggalJadwalHarian.text = bookingKelasData.HARI_JADWAL_UMUM + " / " + bookingKelasData.TANGGAL_JADWAL_HARIAN
                btnHadir.setOnClickListener {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin mempresensi member " + bookingKelasData.NAMA_MEMBER +
                            " untuk kelas " + bookingKelasData.NAMA_KELAS +
                            " pada tanggal " + bookingKelasData.TANGGAL_JADWAL_HARIAN + " menjadi HADIR?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreateJadwalHarian> = ClientBookingKelas.apiService.setHadir(
                                    bookingKelasData.ID_MEMBER,
                                    bookingKelasData.ID_JADWAL_HARIAN, currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreateJadwalHarian?> {
                                    override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                                        if(response.body()?.stt != true){
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.INFO,true).show()
                                        } else {
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.SUCCESS,true).show()
                                        }
                                    }

                                    override fun onFailure(call: Call<ResponseCreateJadwalHarian?>, t: Throwable) {
                                        FancyToast.makeText(context, t.message,
                                            FancyToast.LENGTH_LONG,
                                            FancyToast.ERROR,true).show()
                                    }
                                })
                            }
                        })
                        .setNegativeButton("NO", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                            }
                        })
                        .show()
                }
                btnTidakhadir.setOnClickListener {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin mempresensi member " + bookingKelasData.NAMA_MEMBER +
                            " untuk kelas " + bookingKelasData.NAMA_KELAS +
                            " pada tanggal " + bookingKelasData.TANGGAL_JADWAL_HARIAN + " menjadi TIDAK HADIR?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreateJadwalHarian> = ClientBookingKelas.apiService.setTidakHadir(
                                    bookingKelasData.ID_MEMBER,
                                    bookingKelasData.ID_JADWAL_HARIAN, currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreateJadwalHarian?> {
                                    override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                                        if(response.body()?.stt != true){
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.INFO,true).show()
                                        } else {
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.SUCCESS,true).show()
                                        }
                                    }

                                    override fun onFailure(call: Call<ResponseCreateJadwalHarian?>, t: Throwable) {
                                        FancyToast.makeText(context, t.message,
                                            FancyToast.LENGTH_LONG,
                                            FancyToast.ERROR,true).show()
                                    }
                                })
                            }
                        })
                        .setNegativeButton("NO", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                            }
                        })
                        .show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BookingPresensiKelasViewHolder {
        return BookingPresensiKelasViewHolder(
            ListDataBookingPresensiKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BookingPresensiKelasViewHolder, position:
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