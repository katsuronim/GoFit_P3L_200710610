package com.example.gofit_p3l_10610.Member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_p3l_10610.Member.Fragment.DataHistoryGymFragment
import com.example.gofit_p3l_10610.Member.Fragment.DataHistoryKelasFragment
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.ActivityReadHistoryGymBinding
import com.example.gofit_p3l_10610.databinding.ActivityReadHistoryKelasBinding

class ReadHistoryKelasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReadHistoryKelasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadHistoryKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val idUser = intent.getStringExtra("idUser")
        val nama = intent.getStringExtra("nama")
        val jabatan = intent.getStringExtra("jabatan")
        val username = intent.getStringExtra("username")
        val tglMulai = intent.getStringExtra("tglMulai")
        val tglAkhir = intent.getStringExtra("tglAkhir")


        if (idUser != null) {
            if (nama != null) {
                if (tglMulai != null) {
                    if (tglAkhir != null) {
                        showDataFragment(idUser, nama, tglMulai, tglAkhir)
                    }
                }
            }
        }
    }

    fun showDataFragment(idUser: String, nama: String, tglMulai: String, tglAkhir: String) {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction =
            mFragmentManager.beginTransaction()
        val mFragment = DataHistoryKelasFragment()
        val mBundle = Bundle()
        mBundle.putString("idUser", idUser)
        mBundle.putString("nama", nama)
        mBundle.putString("tglMulai", tglMulai)
        mBundle.putString("tglAkhir", tglAkhir)
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}