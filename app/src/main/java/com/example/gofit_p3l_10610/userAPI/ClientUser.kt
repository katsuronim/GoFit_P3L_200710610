package com.example.gofit_p3l_10610.userAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientUser {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://backend10610.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(ApiService::class.java)
}