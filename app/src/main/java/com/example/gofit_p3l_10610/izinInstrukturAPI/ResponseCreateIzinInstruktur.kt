package com.example.gofit_p3l_10610.izinInstrukturAPI

import com.google.gson.annotations.SerializedName

class ResponseCreateIzinInstruktur (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<IzinInstruktur>,
)