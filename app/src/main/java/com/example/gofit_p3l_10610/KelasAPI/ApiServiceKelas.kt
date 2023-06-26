package com.example.gofit_p3l_10610.KelasAPI

import com.example.gofit_p3l_10610.userAPI.ResponseDataUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

public interface ApiServiceKelas {
    @GET("api/kelas")
    open fun getKelas(): Call<ResponseCreateKelas?>?
}