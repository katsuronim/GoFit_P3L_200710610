package com.example.gofit_p3l_10610.BookingKelasAPI

import com.google.gson.annotations.SerializedName

class JadwalHarian (
    @SerializedName("ID_JADWAL_HARIAN") val ID_JADWAL_HARIAN: Int?,
    @SerializedName("TANGGAL_JADWAL_HARIAN") val TANGGAL_JADWAL_HARIAN:String,
    @SerializedName("HARI_JADWAL_UMUM") val HARI_JADWAL_UMUM :String,
    @SerializedName("JAM_JADWAL_UMUM") val JAM_JADWAL_UMUM : String,
    @SerializedName("NAMA_KELAS") val NAMA_KELAS : String
)