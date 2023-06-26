package com.example.gofit_p3l_10610.Member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_p3l_10610.Member.Fragment.DataBookingGymFragment
import com.example.gofit_p3l_10610.Member.Fragment.DataBookingKelasFragment
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.ActivityReadBookingGymBinding
import com.example.gofit_p3l_10610.databinding.ActivityReadBookingPaketBinding

class ReadBookingGymActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReadBookingGymBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBookingGymBinding.inflate(layoutInflater)
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
        val mFragment = DataBookingGymFragment()
        val mBundle = Bundle()
        mBundle.putString("idUser", idUser)
        mBundle.putString("nama", nama)
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_dataBookingGym, mFragment).commit()
    }
}