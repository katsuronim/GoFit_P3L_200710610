package com.example.gofit_p3l_10610.KelasAPI

import com.google.gson.annotations.SerializedName

class Kelas (
    @SerializedName("ID_KELAS") val ID_KELAS: String?,
    @SerializedName("NAMA_KELAS") val NAMA_KELAS:String,
    @SerializedName("HARGA_KELAS") val HARGA_KELAS :String
)