package com.example.gofit_p3l_10610.PresensiInstrukturAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientPresensiInstruktur {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://backend10610.gofit10603.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(ApiServicePresensiInstruktur::class.java)
}