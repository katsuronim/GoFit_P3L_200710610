package com.example.gofit_p3l_10610.BookingGymAPI

import com.google.gson.annotations.SerializedName

class BookingPresensiGym (
    @SerializedName("NOMOR_STRUK_BOOKING_PRESENSI_GYM") val NOMOR_STRUK_BOOKING_PRESENSI_GYM: String,
    @SerializedName("ID_MEMBER") val ID_MEMBER:String,
    @SerializedName("TANGGAL_BOOKING_GYM") val TANGGAL_BOOKING_GYM :String,
    @SerializedName("TANGGAL_YANG_DIBOOKING_GYM") val TANGGAL_YANG_DIBOOKING_GYM :String,
    @SerializedName("SESI_DIBOOKING") val SESI_DIBOOKING : String,
    @SerializedName("STATUS_PRESENSI_GYM") val STATUS_PRESENSI_GYM : String,
    @SerializedName("JAM_PRESENSI_GYM") val JAM_PRESENSI_GYM : String
    )