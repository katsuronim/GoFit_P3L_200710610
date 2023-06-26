package com.example.gofit_p3l_10610.Instruktur

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gofit_p3l_10610.databinding.ActivityAddIzinBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateIzinInstruktur
import com.google.gson.Gson
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddIzinActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddIzinBinding
    private val listInstruktur = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddIzinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val extras = intent.extras

        val idUser = extras!!.getString("idUser").toString()
        val nama = extras!!.getString("nama").toString()
        val jabatan = extras!!.getString("jabatan").toString()
        val username = extras!!.getString("username").toString()

        binding.btnAdd.setOnClickListener{
            val instrukturPengganti: String = binding.txtIdInstrukturPengganti.text.toString()
            val tglIzin: String = binding.tglIzinView.text.toString()
            val sesiIzin: String = binding.txtJamSesiIzin.text.toString()
            val alasanIzin: String = binding.txtAlasanIzin.text.toString()

            if(instrukturPengganti.length == 0){
                binding.txtIdInstrukturPengganti.setError("Tidak boleh kosong!")
            }
            if (tglIzin.length == 0){
                FancyToast.makeText(applicationContext, "Input tanggal tidak boleh kosong",
                    FancyToast.LENGTH_LONG,
                    FancyToast.INFO,true).show()
            }
            if (sesiIzin.length == 0){
                binding.txtJamSesiIzin.setError("Tidak boleh kosong!")
            }
            if (alasanIzin.length == 0){
                binding.txtAlasanIzin.setError("Tidak boeh kosong!")
            }

            if(instrukturPengganti.length != 0 && sesiIzin.length != 0 && alasanIzin.length != 0){
                saveData(idUser, nama, jabatan, username)
            }

        }
        binding.tvTglIzin.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener{
                    view,year,month,dayofMonth-> binding.tvTglIzin.text = dateToString(year,month,dayofMonth)
            }
            dateDialog(this,datePicker).show()
        }
    }

    fun saveData(idUser: String, nama:String, jabatan: String, username: String){
        with(binding){
            val instrukturPengganti = txtIdInstrukturPengganti.text.toString()
            val tglIzin = tvTglIzin.text.toString()
            val sesiIzin = txtJamSesiIzin.text.toString()
            val alasanIzin = txtAlasanIzin.text.toString()

            val call: Call<ResponseCreateIzinInstruktur>? = ClientIzinInstruktur.apiService.createData(
                idInstruktur = idUser, instrukturPengganti, tglIzin, sesiIzin, alasanIzin)
            call?.enqueue(object : Callback<ResponseCreateIzinInstruktur?> {
                override fun onResponse(call: Call<ResponseCreateIzinInstruktur?>, response: Response<ResponseCreateIzinInstruktur?>) {
                    val gson = Gson()
                    val responseString = gson.toJson(response.body()?.data)
                    if(response.body()?.stt != true){
//                        FancyToast.makeText(applicationContext, idUser + ", " + instrukturPengganti + ", " + tglIzin + ", " + sesiIzin + ", " + alasanIzin,
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

                override fun onFailure(call: Call<ResponseCreateIzinInstruktur?>, t: Throwable) {
                    FancyToast.makeText(applicationContext, t.message,
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                }
            })
        }
    }

    private fun dateToString(year: Int, month: Int, dayofMonth:Int):String{
        return year.toString()+"-"+(month+1)+"-"+dayofMonth.toString()
    }

    private fun dateDialog(context: Context, datePicker: DatePickerDialog.OnDateSetListener): DatePickerDialog {
        val calender = Calendar.getInstance()
        return DatePickerDialog(
            context,datePicker,
            calender[Calendar.YEAR],
            calender[Calendar.MONTH],
            calender[Calendar.DAY_OF_MONTH],
        )
    }
}