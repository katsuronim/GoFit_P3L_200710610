package com.example.gofit_p3l_10610.BookingGymAPI

import com.google.gson.annotations.SerializedName

class ResponseCreateBookingPresensiGym (
    @SerializedName("success") var stt:Boolean,
    @SerializedName("message") var message:String,
    @SerializedName("data") var data:List<BookingPresensiGym>,
)