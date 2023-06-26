package com.example.gofit_p3l_10610.Member

import android.R
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.example.gofit_p3l_10610.BookingGymAPI.ClientGym
import com.example.gofit_p3l_10610.BookingGymAPI.ResponseCreateBookingPresensiGym
import com.example.gofit_p3l_10610.BookingKelasAPI.ClientBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.JadwalHarian
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateJadwalHarian
import com.example.gofit_p3l_10610.databinding.ActivityAddBookingGymBinding
import com.example.gofit_p3l_10610.databinding.ActivityAddBookingKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_add_booking_gym.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddBookingGymActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddBookingGymBinding
    private var spinner: Spinner? = null
    val idJadwalHarian = ArrayList<String>()
    val namaKelas = ArrayList<String>()
    val tanggalJadwalHarian = ArrayList<String>()
    val hariJadwalUmum = ArrayList<String>()
    val jamJadwalUmum = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBookingGymBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val extras = intent.extras

        val idUser = extras!!.getString("idUser").toString()
        val nama = extras!!.getString("nama").toString()
        val jabatan = extras!!.getString("jabatan").toString()
        val username = extras!!.getString("username").toString()

        val items = listOf("Silahkan memilih jadwal", "7-9", "9-11", "11-13", "13-15", "15-17", "17-19", "19-21")
        var selectedItem = ""

        spinner = binding.spinner1
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        spinner!!.adapter = adapter
        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem != "Silahkan memilih jadwal") {
//                    // Handle the selected item
//                    FancyToast.makeText(applicationContext, selectedItem,
//                        FancyToast.LENGTH_LONG,
//                        FancyToast.INFO,true).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                val defaultText = "Silahkan memilih jadwal"
                selectedItem = parent.selectedItem?.toString() ?: defaultText
                if (selectedItem == defaultText) {
                    // Handle the case when nothing is selected
                    FancyToast.makeText(applicationContext, "Mohon memilih jadwal",
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                }
            }

        }

        binding.tvTglBooking.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener{
                    view,year,month,dayofMonth-> binding.tvTglBooking.text = dateToString(year,month,dayofMonth)
            }
            dateDialog(this,datePicker).show()
        }


        binding.btnAdd.setOnClickListener{
            val builder: AlertDialog.Builder = AlertDialog.Builder(this@AddBookingGymActivity)
            builder.setMessage("Apakah anda yakin ingin melakukan booking pada tanggal " + binding.tvTglBooking.text +
                    " pada jam " + selectedItem + "?")
                .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface, i: Int){
                        val tanggal = tv_tglBooking.text.toString()

                        val call: Call<ResponseCreateBookingPresensiGym> = ClientGym.apiService.createData(idUser, tanggal, selectedItem)
                        call?.enqueue(object : Callback<ResponseCreateBookingPresensiGym?> {
                            override fun onResponse(call: Call<ResponseCreateBookingPresensiGym?>, response: Response<ResponseCreateBookingPresensiGym?>) {
                                if(response != null){
                                    if(selectedItem == "Silahkan memilih jadwal"){
                                        FancyToast.makeText(applicationContext, "Mohon pilih jadwal jam untuk dibooking!",
                                            FancyToast.LENGTH_LONG,
                                            FancyToast.ERROR,true).show()
                                    } else {
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
                            }

                            override fun onFailure(call: Call<ResponseCreateBookingPresensiGym?>, t: Throwable) {
                                FancyToast.makeText(applicationContext, t.message,
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