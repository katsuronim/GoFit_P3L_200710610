package com.example.gofit_p3l_10610.userAPI

import com.google.gson.annotations.SerializedName

class Member(
    @SerializedName("ID_MEMBER") val ID_MEMBER:String,
    @SerializedName("NAMA_MEMBER") val NAMA_MEMBER:String,
    @SerializedName("ALAMAT_MEMBER") val ALAMAT_MEMBER:String,
    @SerializedName("NO_TELEPON_MEMBER") val NO_TELEPON_MEMBER:String,
    @SerializedName("TANGGAL_LAHIR_MEMBER") val TANGGAL_LAHIR_MEMBER:String,
    @SerializedName("EMAIL_MEMBER") val EMAIL_MEMBER:String,
    @SerializedName("USERNAME_MEMBER") val USERNAME_MEMBER:String,
    @SerializedName("PASSWORD_MEMBER") val PASSWORD_MEMBER:String,
    @SerializedName("TANGGAL_KADALUARSA_MEMBER") val TANGGAL_KADALUARSA_MEMBER:String,
    @SerializedName("SALDO") val SALDO:String,
    )