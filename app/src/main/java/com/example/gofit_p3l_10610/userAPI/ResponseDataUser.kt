package com.example.gofit_p3l_10610.userAPI

import com.google.gson.annotations.SerializedName

data class ResponseDataUser(
    @SerializedName("message") val stt:String,
    val data:ArrayList<User>
)
