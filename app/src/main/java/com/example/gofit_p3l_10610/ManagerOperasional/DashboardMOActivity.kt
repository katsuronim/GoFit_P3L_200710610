package com.example.gofit_p3l_10610.ManagerOperasional

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_p3l_10610.ManagerOperasional.Fragment.DashboardMOFragment
import com.example.gofit_p3l_10610.ManagerOperasional.Fragment.DataPresensiInstrukturFragment
import com.example.gofit_p3l_10610.ManagerOperasional.Fragment.ProfileMOFragment
import com.example.gofit_p3l_10610.Member.Fragment.BookingGymFragment
import com.example.gofit_p3l_10610.Member.Fragment.BookingKelasFragment
import com.example.gofit_p3l_10610.Member.Fragment.DashboardMemberFragment
import com.example.gofit_p3l_10610.R

class DashboardMOActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_moactivity)
        val intent = intent

        val extras = intent.extras

        idUser = extras!!.getString("idUser").toString()
        nama = extras!!.getString("nama").toString()
        jabatan = extras!!.getString("jabatan").toString()
        username = extras!!.getString("username").toString()

        val firstFragment= DashboardMOFragment()
        val secondFragment= DataPresensiInstrukturFragment()
        val thirdFragment= ProfileMOFragment()
//        val fourth= FragmentCreator()

        val bottomNavigationView = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.bottomNavigationViewMO
        )

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.presensiInstruktur ->setCurrentFragment(secondFragment)
                R.id.user ->setCurrentFragment(thirdFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@DashboardMOActivity)
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
            replace(R.id.flFragmentMO,fragment)
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