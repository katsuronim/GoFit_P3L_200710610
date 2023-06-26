package com.example.gofit_p3l_10610

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.databinding.ActivityForgotPassBinding
import com.example.gofit_p3l_10610.databinding.ActivityLoginBinding
import com.example.gofit_p3l_10610.userAPI.ClientUser
import com.example.gofit_p3l_10610.userAPI.ResponseCreate
import com.example.gofit_p3l_10610.userAPI.ResponseCreatePegawai
import com.example.gofit_p3l_10610.userAPI.User
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPassActivity : AppCompatActivity() {
    var tv: ShimmerTextView? = null
    var shimmer: Shimmer? = null
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputEmail: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var binding : ActivityForgotPassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        binding = ActivityForgotPassBinding.inflate(layoutInflater)
        inputEmail = findViewById(R.id.inputLayoutEmail)
        inputUsername = findViewById(R.id.inputLayoutUsername)
        mainLayout = findViewById(R.id.mainLayout)
        val extras = Bundle()
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnEnter: Button = findViewById(R.id.btnEnter)
        val tv: ShimmerTextView = findViewById(R.id.textView)


        btnClear.setOnClickListener {
            inputEmail.getEditText()?.setText("")
            inputUsername.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        btnEnter.setOnClickListener(View.OnClickListener {
            val email: String = inputEmail.getEditText()?.getText().toString()
            val username: String = inputUsername.getEditText()?.getText().toString()

            if(username.length == 0 && email.length == 0){
                inputEmail.setError("Tidak boleh kosong!")
                inputUsername.setError("Tidak boleh kosong!")
            } else if (email.length == 0){
                inputEmail.setError("Tidak boleh kosong!")
            } else if (username.length == 0){
                inputUsername.setError("Tidak boleh kosong!")
            }
            val call: Call<ResponseCreatePegawai>? = ClientUser.apiService.forgotPassword(email,username)
            call?.enqueue(object : Callback<ResponseCreatePegawai?> {
                override fun onResponse(call: Call<ResponseCreatePegawai?>, response: Response<ResponseCreatePegawai?>) {
                    if(response.body()?.stt == true){
                        val user: String? = response.body()?.message
                        val intent = Intent(this@ForgotPassActivity, DashboardActivity::class.java)
                        intent.putExtras(extras)
                        FancyToast.makeText(applicationContext, response.body()?.message.toString(),
                            FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS,true).show()
                        startActivity(intent)
                        finish()
                    } else {
                        FancyToast.makeText(applicationContext, "email atau username salah!",
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                    }
                }

                override fun onFailure(call: Call<ResponseCreatePegawai?>, t: Throwable) {
                    // Handle the error
//                    FancyToast.makeText(applicationContext,t.message,
//                        FancyToast.LENGTH_LONG,
//                        FancyToast.ERROR,true).show()
                    FancyToast.makeText(applicationContext, "username atau password salah!",
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                }
            })
        })
    }
}