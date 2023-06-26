package com.example.gofit_p3l_10610

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_p3l_10610.JadwalHarian.DataJadwalHarianFragment
import com.example.gofit_p3l_10610.Kelas.DataKelasFragment
import com.example.gofit_p3l_10610.databinding.ActivityReadJadwalHarianBinding
import com.example.gofit_p3l_10610.databinding.ActivityReadKelasBinding

class ReadJadwalHarianActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReadJadwalHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadJadwalHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataFragment()
    }

    fun showDataFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction =
            mFragmentManager.beginTransaction()
        val mFragment = DataJadwalHarianFragment()
        val mBundle = Bundle()
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_dataJadwalHarian, mFragment).commit()
    }
}