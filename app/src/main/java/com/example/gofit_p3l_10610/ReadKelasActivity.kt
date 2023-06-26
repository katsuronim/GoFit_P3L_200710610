package com.example.gofit_p3l_10610

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_p3l_10610.Instruktur.Fragment.DataIzinFragment
import com.example.gofit_p3l_10610.Kelas.DataKelasFragment
import com.example.gofit_p3l_10610.databinding.ActivityReadIzinBinding
import com.example.gofit_p3l_10610.databinding.ActivityReadKelasBinding

class ReadKelasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReadKelasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataFragment()
    }

    fun showDataFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction =
            mFragmentManager.beginTransaction()
        val mFragment = DataKelasFragment()
        val mBundle = Bundle()
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}