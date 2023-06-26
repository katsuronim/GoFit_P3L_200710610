package com.example.gofit_p3l_10610.userAPI

import com.google.gson.annotations.SerializedName

class DepositKelasMember(
    @SerializedName("ID_DEPOSIT_MEMBER") val ID_DEPOSIT_MEMBER:String,
    @SerializedName("ID_MEMBER") val ID_MEMBER:String,
    @SerializedName("ID_KELAS") val ID_KELAS:String,
    @SerializedName("DEPOSIT_PAKET_KELAS") val DEPOSIT_PAKET_KELAS:String,
    @SerializedName("TANGGAL_KADALUARSA") val TANGGAL_KADALUARSA:String,
    @SerializedName("NAMA_KELAS") val NAMA_KELAS:String
)