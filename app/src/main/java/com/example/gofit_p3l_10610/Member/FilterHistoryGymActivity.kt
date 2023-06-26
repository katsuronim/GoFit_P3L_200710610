package com.example.gofit_p3l_10610.Member

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_p3l_10610.databinding.ActivityFilterHistoryBinding
import com.example.gofit_p3l_10610.databinding.ActivityFilterHistoryGymBinding
import com.shashank.sony.fancytoastlib.FancyToast

class FilterHistoryGymActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFilterHistoryGymBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterHistoryGymBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val extras = intent.extras

        val idUser = extras!!.getString("idUser").toString()
        val nama = extras!!.getString("nama").toString()
        val jabatan = extras!!.getString("jabatan").toString()
        val username = extras!!.getString("username").toString()

        binding.btnGenerate.setOnClickListener{
            val tglMulai: String = binding.tvTglMulai.text.toString()
            val tglAkhir: String = binding.tvTglAkhir.text.toString()

            if (tglMulai.length == 0){
                FancyToast.makeText(applicationContext, "Input tanggal tidak boleh kosong",
                    FancyToast.LENGTH_LONG,
                    FancyToast.INFO,true).show()
            }
            if (tglAkhir.length == 0){
                FancyToast.makeText(applicationContext, "Input tanggal tidak boleh kosong",
                    FancyToast.LENGTH_LONG,
                    FancyToast.INFO,true).show()
            }
            extras.putString("idUser", idUser)
            extras.putString("nama", nama)
            extras.putString("jabatan", jabatan)
            extras.putString("username", username)
            extras.putString("tglMulai", tglMulai)
            extras.putString("tglAkhir", tglAkhir)
            val intent = Intent(this@FilterHistoryGymActivity, ReadHistoryGymActivity::class.java)
            intent.putExtras(extras)
//            FancyToast.makeText(applicationContext, "Selamat Datang, Manager Operasional " + user?.getNama().toString(),
//                FancyToast.LENGTH_LONG,
//                FancyToast.SUCCESS,true).show()
            startActivity(intent)
            finish()
        }
        binding.tvTglMulai.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener{
                    view,year,month,dayofMonth-> binding.tvTglMulai.text = dateToString(year,month,dayofMonth)
            }
            dateDialog(this,datePicker).show()
        }
        binding.tvTglAkhir.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener{
                    view,year,month,dayofMonth-> binding.tvTglAkhir.text = dateToString(year,month,dayofMonth)
            }
            dateDialog(this,datePicker).show()
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