package com.example.gofit_p3l_10610.Instruktur

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.DashboardInstrukturFragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.DataPresensiKelasFragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.IzinInstrukturFragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.ProfileInstrukturFragment
import com.example.gofit_p3l_10610.R

class DashboardInstrukturActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_instruktur)
        val intent = intent

        val extras = intent.extras

        id = extras!!.getInt("id")
        idUser = extras!!.getString("idUser").toString()
        nama = extras!!.getString("nama").toString()
        jabatan = extras!!.getString("jabatan").toString()
        username = extras!!.getString("username").toString()

        val firstFragment= DashboardInstrukturFragment()
        val secondFragment= IzinInstrukturFragment()
        val thirdFragment= DataPresensiKelasFragment()
        val fourthFragment= ProfileInstrukturFragment()
//        val fifthFragment= FragmentCreator()

        val bottomNavigationView = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.bottomNavigationView
        )

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.izin ->setCurrentFragment(secondFragment)
                R.id.presensiMember ->setCurrentFragment(thirdFragment)
                R.id.user ->setCurrentFragment(fourthFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@DashboardInstrukturActivity)
                    builder.setMessage("Are you sure want to exit?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                finishAndRemoveTask()
                            }
                        })
                        .setNegativeButton("NO", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                            }
                        })
                        .show()
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
    }
    public fun getIdUser(): String {
        return idUser
    }

    public fun getNama(): String {
        return nama
    }

    public fun getJabatan(): String {
        return jabatan
    }

    public fun getUsername(): String {
        return username
    }
}