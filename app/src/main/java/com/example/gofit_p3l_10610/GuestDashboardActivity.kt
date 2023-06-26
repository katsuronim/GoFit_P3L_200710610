package com.example.gofit_p3l_10610

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gofit_p3l_10610.Instruktur.ReadIzinActivity
import com.example.gofit_p3l_10610.databinding.ActivityForgotPassBinding
import com.example.gofit_p3l_10610.databinding.ActivityGuestDashboardBinding
import com.romainpiel.shimmer.ShimmerTextView

class GuestDashboardActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""
    private lateinit var binding : ActivityGuestDashboardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_dashboard)
        binding = ActivityGuestDashboardBinding.inflate(layoutInflater)
        val btnJadwalHarian: Button = findViewById(R.id.btnJadwal)
        val btnPrice: Button = findViewById(R.id.btnPrice)
        val btnImage: Button = findViewById(R.id.btnImage)


        btnJadwalHarian.setOnClickListener{
            val intent = Intent(this@GuestDashboardActivity, ReadJadwalHarianActivity::class.java)
            startActivity(intent)
        }
        btnPrice.setOnClickListener{
            val intent = Intent(this@GuestDashboardActivity, ReadKelasActivity::class.java)
            startActivity(intent)
        }
        btnImage.setOnClickListener{
            val intent = Intent(this@GuestDashboardActivity, GambarFasilitasActivity::class.java)
            startActivity(intent)
        }
    }
}