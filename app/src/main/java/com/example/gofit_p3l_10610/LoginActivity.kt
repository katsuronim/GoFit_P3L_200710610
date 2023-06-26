package com.example.gofit_p3l_10610

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.ManagerOperasional.DashboardMOActivity
import com.example.gofit_p3l_10610.Member.DashboardMemberActivity
import com.example.gofit_p3l_10610.databinding.ActivityLoginBinding
import com.example.gofit_p3l_10610.userAPI.ClientUser.apiService
import com.example.gofit_p3l_10610.userAPI.ResponseCreate
import com.example.gofit_p3l_10610.userAPI.User
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    var tv: ShimmerTextView? = null
    var shimmer: Shimmer? = null
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val extras = Bundle()
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnForgot: Button = findViewById(R.id.btnForgot)
        val tv: ShimmerTextView = findViewById(R.id.textView)

        shimmer = Shimmer()
        shimmer!!.start(tv)

        btnClear.setOnClickListener {
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        btnForgot.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPassActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener(View.OnClickListener {
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            if(username.length == 0 && password.length == 0){
                inputUsername.setError("Tidak boleh kosong!")
                inputPassword.setError("Tidak boleh kosong!")
            } else if (username.length == 0){
                inputUsername.setError("Tidak boleh kosong!")
            } else if (password.length == 0){
                inputPassword.setError("Tidak boleh kosong!")
            }
            val call: Call<ResponseCreate>? = apiService.login(username,password)
            call?.enqueue(object : Callback<ResponseCreate?> {
                override fun onResponse(call: Call<ResponseCreate?>, response: Response<ResponseCreate?>) {
                    if(response.body()?.stt == true){
                        val user: User? = response.body()?.user
                        // Do something with the user object
                        extras.putInt("id", user?.getId()!!)
                        extras.putString("idUser", user.getIdUser().toString())
                        extras.putString("nama", user.getNama().toString())
                        extras.putString("jabatan", user.getJabatan().toString())
                        extras.putString("username", user.getUsername().toString())
                        if(user?.getJabatan() == "Member"){
                            val intent = Intent(this@LoginActivity, DashboardMemberActivity::class.java)
                            intent.putExtras(extras)
                            FancyToast.makeText(applicationContext, "Selamat Datang, Member " + user?.getNama().toString(),
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show()
                            startActivity(intent)
                            finish()
                        } else if(user?.getJabatan() == "Instruktur"){
                            val intent = Intent(this@LoginActivity, DashboardInstrukturActivity::class.java)
                            intent.putExtras(extras)
                            FancyToast.makeText(applicationContext, "Selamat Datang, Instruktur " + user?.getNama().toString(),
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show()
                            startActivity(intent)
                            finish()
                        } else if(user?.getJabatan() == "Manager Operasional"){
                            val intent = Intent(this@LoginActivity, DashboardMOActivity::class.java)
                            intent.putExtras(extras)
                            FancyToast.makeText(applicationContext, "Selamat Datang, Manager Operasional " + user?.getNama().toString(),
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show()
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        FancyToast.makeText(applicationContext, response.body()?.user?.getNama().toString(),
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                    }
                }

                override fun onFailure(call: Call<ResponseCreate?>, t: Throwable) {
                    // Handle the error
                    FancyToast.makeText(applicationContext,t.message,
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                    FancyToast.makeText(applicationContext, "Username atau Password salah!",
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                }
            })
        })
    }
}