package com.example.gofit_p3l_10610.Instruktur

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gofit_p3l_10610.Instruktur.Fragment.DataIzinFragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.IzinInstrukturFragment
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.ActivityReadIzinBinding
import com.example.gofit_p3l_10610.userAPI.ClientUser
import com.example.gofit_p3l_10610.userAPI.ResponseCreate
import com.example.gofit_p3l_10610.userAPI.ResponseDataUser
import com.example.gofit_p3l_10610.userAPI.User
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ReadIzinActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReadIzinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadIzinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val idUser = intent.getStringExtra("idUser")
        val nama = intent.getStringExtra("nama")
        val jabatan = intent.getStringExtra("jabatan")
        val username = intent.getStringExtra("username")

        if (idUser != null) {
            if (nama != null) {
                showDataFragment(idUser, nama)
            }
        }
    }

        fun showDataFragment(idUser: String, nama: String) {
            val mFragmentManager = supportFragmentManager
            val mFragmentTransaction =
                mFragmentManager.beginTransaction()
            val mFragment = DataIzinFragment()
            val mBundle = Bundle()
            mBundle.putString("idUser", idUser)
            mBundle.putString("nama", nama)
            mFragment.arguments = mBundle
            mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
        }
}