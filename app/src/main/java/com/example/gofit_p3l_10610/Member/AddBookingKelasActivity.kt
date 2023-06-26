package com.example.gofit_p3l_10610.Member

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.gofit_p3l_10610.BookingKelasAPI.*
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.Member.Fragment.BookingKelasFragment
import com.example.gofit_p3l_10610.Member.Fragment.DashboardMemberFragment
import com.example.gofit_p3l_10610.databinding.ActivityAddBookingKelasBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateIzinInstruktur
import com.google.gson.Gson
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddBookingKelasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddBookingKelasBinding
    private var spinner: Spinner? = null
    val idJadwalHarian = ArrayList<String>()
    val namaKelas = ArrayList<String>()
    val tanggalJadwalHarian = ArrayList<String>()
    val hariJadwalUmum = ArrayList<String>()
    val jamJadwalUmum = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBookingKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val extras = intent.extras

        val idUser = extras!!.getString("idUser").toString()
        val nama = extras!!.getString("nama").toString()
        val jabatan = extras!!.getString("jabatan").toString()
        val username = extras!!.getString("username").toString()

        setData()

        spinner = binding.spinner1
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            R.layout.simple_spinner_item, idJadwalHarian
        )
        setSpinner(adapter)

        binding.btnAdd.setOnClickListener{
            val input = binding.txtInput.text.toString()

            if(input.length == 0){
                binding.txtInput.setError("Tidak boleh kosong!")
            } else {
                val call: Call<ResponseCreateJadwalHarian>? = ClientBookingKelas.apiService.createData(idUser, input)
                call?.enqueue(object : Callback<ResponseCreateJadwalHarian?> {
                    override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                        if(response != null){
                            if(response.body()?.stt != true){
//                        FancyToast.makeText(applicationContext, response.body()?.message.toString(),
//                            FancyToast.LENGTH_LONG,
//                            FancyToast.INFO,true).show()
                                FancyToast.makeText(applicationContext, response.body()?.message.toString(),
                                    FancyToast.LENGTH_LONG,
                                    FancyToast.INFO,true).show()
                            } else {
                                FancyToast.makeText(applicationContext, response.body()?.message.toString(),
                                    FancyToast.LENGTH_LONG,
                                    FancyToast.SUCCESS,true).show()
                                finish()
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseCreateJadwalHarian?>, t: Throwable) {
                        FancyToast.makeText(applicationContext, t.message,
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                    }
                })
            }
        }
    }

    fun setData(){
        val call: Call<ResponseCreateJadwalHarian> = ClientBookingKelas.apiService.getJadwalHarian("blank")
        call?.enqueue(object : Callback<ResponseCreateJadwalHarian> {
            override fun onResponse(call: Call<ResponseCreateJadwalHarian>, response: Response<ResponseCreateJadwalHarian>) {
                if (response.isSuccessful){
                    val jadwalHarian: List<JadwalHarian>? = response.body()?.data
                    for (i in 0 until jadwalHarian!!.size) {
                        val item = jadwalHarian.get(i)
                        idJadwalHarian.add(item.ID_JADWAL_HARIAN.toString() + " - " + item.HARI_JADWAL_UMUM + " - " + item.TANGGAL_JADWAL_HARIAN + " - " + item.NAMA_KELAS + " - " + item.JAM_JADWAL_UMUM)
                        namaKelas.add(item.NAMA_KELAS)
                        tanggalJadwalHarian.add(item.TANGGAL_JADWAL_HARIAN)
                        hariJadwalUmum.add(item.HARI_JADWAL_UMUM)
                        jamJadwalUmum.add(item.JAM_JADWAL_UMUM)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateJadwalHarian>, t: Throwable) {
            }
        })
    }

    fun saveData(idUser: String, nama:String, jabatan: String, username: String, input: String){
        with(binding){


        }
    }

    fun setSpinner(adapter: ArrayAdapter<String>){
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = adapter
        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.btnAdd.setOnClickListener{
                    FancyToast.makeText(applicationContext, "Mohon pilih satu jadwal untuk booking!",
                        FancyToast.LENGTH_LONG,
                        FancyToast.SUCCESS,true).show()
                }
            }
        }
    }
}