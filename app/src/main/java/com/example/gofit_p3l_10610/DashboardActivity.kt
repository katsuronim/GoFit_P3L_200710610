package com.example.gofit_p3l_10610

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView

class DashboardActivity : AppCompatActivity() {
    var tv: ShimmerTextView? = null
    var shimmer: Shimmer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        val dashboard = layoutInflater.inflate(R.layout.activity_dashboard, null)
        val btnGuest: Button = findViewById(R.id.btnGuest)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tv: ShimmerTextView = findViewById(R.id.textView)
        shimmer = Shimmer()
        shimmer!!.start(tv)

        btnGuest.setOnClickListener {
            val moveGuest = Intent(this, GuestDashboardActivity::class.java)
            startActivity(moveGuest)
        }

        btnLogin.setOnClickListener {
            val moveLogin = Intent(this, LoginActivity::class.java)
            startActivity(moveLogin)
        }
    }
}