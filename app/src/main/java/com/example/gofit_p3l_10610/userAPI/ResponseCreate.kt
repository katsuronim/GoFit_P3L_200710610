package com.example.gofit_p3l_10610.userAPI

import com.google.gson.annotations.SerializedName

class ResponseCreate (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("user") var user:User,
    @SerializedName("token") var token:String,
)