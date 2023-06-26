package com.example.gofit_p3l_10610.userAPI

import com.google.gson.annotations.SerializedName

class ResponseCreateMO (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:Pegawai,
)