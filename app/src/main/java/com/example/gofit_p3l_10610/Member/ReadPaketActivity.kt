package com.example.gofit_p3l_10610.Member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_p3l_10610.Member.Fragment.DataBookingKelasFragment
import com.example.gofit_p3l_10610.Member.Fragment.DataPaketFragment
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.ActivityReadBookingPaketBinding
import com.example.gofit_p3l_10610.databinding.ActivityReadPaketBinding

class ReadPaketActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReadPaketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadPaketBinding.inflate(layoutInflater)
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
        val mFragment = DataPaketFragment()
        val mBundle = Bundle()
        mBundle.putString("idUser", idUser)
        mBundle.putString("nama", nama)
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}