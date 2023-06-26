package com.example.gofit_p3l_10610.PresensiInstrukturAPI

import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.google.gson.annotations.SerializedName

class ResponseCreatePresensiInstruktur (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<PresensiInstruktur>,
)