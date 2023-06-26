package com.example.gofit_p3l_10610.Member

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.DashboardInstrukturFragment
import com.example.gofit_p3l_10610.Instruktur.Fragment.IzinInstrukturFragment
import com.example.gofit_p3l_10610.Member.Fragment.BookingGymFragment
import com.example.gofit_p3l_10610.Member.Fragment.BookingKelasFragment
import com.example.gofit_p3l_10610.Member.Fragment.DashboardMemberFragment
import com.example.gofit_p3l_10610.Member.Fragment.ProfileMemberFragment
import com.example.gofit_p3l_10610.R

class DashboardMemberActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_member)
        val intent = intent

        val extras = intent.extras

        idUser = extras!!.getString("idUser").toString()
        nama = extras!!.getString("nama").toString()
        jabatan = extras!!.getString("jabatan").toString()
        username = extras!!.getString("username").toString()

        val firstFragment= DashboardMemberFragment()
        val secondFragment= BookingGymFragment()
        val thirdFragment= BookingKelasFragment()
        val fourthFragment= ProfileMemberFragment()
//        val fifthFragment= FragmentCreator()

        val bottomNavigationViewMember = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.bottomNavigationViewMember
        )

        setCurrentFragment(firstFragment)

        bottomNavigationViewMember.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.bookingGym ->setCurrentFragment(secondFragment)
                R.id.bookingKelas ->setCurrentFragment(thirdFragment)
                R.id.user ->setCurrentFragment(fourthFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@DashboardMemberActivity)
                    builder.setMessage("Are you sure want to exit?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                finishAndRemoveTask()
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
            replace(R.id.flFragmentMember,fragment)
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