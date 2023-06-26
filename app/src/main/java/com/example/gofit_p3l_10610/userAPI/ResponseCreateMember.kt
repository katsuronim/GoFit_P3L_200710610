package com.example.gofit_p3l_10610.userAPI

import com.example.gofit_p3l_10610.izinInstrukturAPI.IzinInstruktur
import com.google.gson.annotations.SerializedName

class ResponseCreateMember (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:Member,
)