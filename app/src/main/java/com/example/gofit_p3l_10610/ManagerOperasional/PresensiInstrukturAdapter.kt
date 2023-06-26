package com.example.gofit_p3l_10610.ManagerOperasional

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ClientPresensiInstruktur
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.JadwalHarian
import com.example.gofit_p3l_10610.PresensiInstrukturAPI.ResponseCreatePresensiInstruktur
import com.example.gofit_p3l_10610.databinding.ListDataPresensiInstrukturBinding
import com.google.gson.Gson
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresensiInstrukturAdapter (
    private val listJadwalHarian: ArrayList<JadwalHarian>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<PresensiInstrukturAdapter.PresensiInstrukturViewHolder>() {
    inner class PresensiInstrukturViewHolder(item: ListDataPresensiInstrukturBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(presensiInstrukturData: JadwalHarian) {
            with(binding) {
                txtHariTanggal.text = presensiInstrukturData.hari_jadwal_umum + " , " + presensiInstrukturData.TANGGAL_JADWAL_HARIAN
                txtKelas.text = "Nama Kelas: "+ presensiInstrukturData.nama_kelas + " / Jam Kelas : " + presensiInstrukturData.jam_jadwal_umum
                txtInstruktur.text = "Nama Instruktur : "+ presensiInstrukturData.nama_instruktur + " / ID Instruktur : " + presensiInstrukturData.ID_INSTRUKTUR

                btnMulai.setOnClickListener{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin memulai kelas " + presensiInstrukturData.nama_kelas +
                            " pada tanggal " + presensiInstrukturData.TANGGAL_JADWAL_HARIAN +
                            " dengan instruktur " + presensiInstrukturData.nama_instruktur + "?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreatePresensiInstruktur>? = ClientPresensiInstruktur.apiService.createData(
                                    presensiInstrukturData.ID_INSTRUKTUR,
                                    presensiInstrukturData.ID_JADWAL_HARIAN.toString(), currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreatePresensiInstruktur?> {
                                    override fun onResponse(call: Call<ResponseCreatePresensiInstruktur?>, response: Response<ResponseCreatePresensiInstruktur?>) {
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

                                    override fun onFailure(call: Call<ResponseCreatePresensiInstruktur?>, t: Throwable) {
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

                btnSelesai.setOnClickListener {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin menyelesaikan kelas " + presensiInstrukturData.nama_kelas +
                            " pada tanggal " + presensiInstrukturData.TANGGAL_JADWAL_HARIAN +
                            " dengan instruktur " + presensiInstrukturData.nama_instruktur + "?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreatePresensiInstruktur>? = ClientPresensiInstruktur.apiService.updateData(
                                    presensiInstrukturData.ID_INSTRUKTUR,
                                    presensiInstrukturData.ID_JADWAL_HARIAN.toString(), currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreatePresensiInstruktur?> {
                                    override fun onResponse(call: Call<ResponseCreatePresensiInstruktur?>, response: Response<ResponseCreatePresensiInstruktur?>) {
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

                                    override fun onFailure(call: Call<ResponseCreatePresensiInstruktur?>, t: Throwable) {
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
            PresensiInstrukturViewHolder {
        return PresensiInstrukturViewHolder(
            ListDataPresensiInstrukturBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: PresensiInstrukturViewHolder, position:
        Int
    ) {
        holder.bind(listJadwalHarian[position])
    }

    override fun getItemCount() = listJadwalHarian.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<JadwalHarian>) {
        listJadwalHarian.clear()
        listJadwalHarian.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(jadwalHarian: JadwalHarian)
        fun onUpdate(jadwalHarian: JadwalHarian)
        fun onDelete(jadwalHarian: JadwalHarian)
        fun onMap(jadwalHarian: JadwalHarian)
    }
}