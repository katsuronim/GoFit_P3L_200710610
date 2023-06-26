package com.example.gofit_p3l_10610.izinInstrukturAPI

import com.google.gson.annotations.SerializedName

class Instruktur(
    @SerializedName("ID_INSTRUKTUR") val ID_INSTRUKTUR:String,
    @SerializedName("NAMA_INSTRUKTUR") val NAMA_INSTRUKTUR:String,
    @SerializedName("ALAMAT_INSTRUKTUR") val ALAMAT_INSTRUKTUR:String,
    @SerializedName("TANGGAL_LAHIR_INSTRUKTUR") val TANGGAL_LAHIR_INSTRUKTUR:String,
    @SerializedName("NO_TELEPON_INSTRUKTUR") val NO_TELEPON_INSTRUKTUR:String,
    @SerializedName("EMAIL_INSTRUKTUR") val EMAIL_INSTRUKTUR:String,
    @SerializedName("USERNAME_INSTRUKTUR") val USERNAME_INSTRUKTUR:String,
    @SerializedName("PASSWORD_INSTRUKTUR") val PASSWORD_INSTRUKTUR:String,
    @SerializedName("KETERLAMBATAN") val KETERLAMBATAN:String,
    )