package com.example.gofit_p3l_10610.PresensiInstrukturAPI

import com.google.gson.annotations.SerializedName

class ResponseCreateJadwalHarian (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<JadwalHarian>,
)