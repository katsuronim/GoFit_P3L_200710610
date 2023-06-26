package com.example.gofit_p3l_10610.userAPI

import com.google.gson.annotations.SerializedName

class Pegawai (
    @SerializedName("ID_PEGAWAI") val ID_PEGAWAI:String,
    @SerializedName("NAMA_PEGAWAI") val NAMA_PEGAWAI:String,
    @SerializedName("ALAMAT_PEGAWAI") val ALAMAT_PEGAWAI:String,
    @SerializedName("TANGGAL_LAHIR_PEGAWAI") val TANGGAL_LAHIR_PEGAWAI:String,
    @SerializedName("NO_TELEPON_PEGAWAI") val NO_TELEPON_PEGAWAI:String,
    @SerializedName("EMAIL_PEGAWAI") val EMAIL_PEGAWAI:String,
    @SerializedName("USERNAME_PEGAWAI") val USERNAME_PEGAWAI:String,
    @SerializedName("PASSWORD_PEGAWAI") val PASSWORD_PEGAWAI:String
)