package com.example.gofit_p3l_10610.izinInstrukturAPI

import com.google.gson.annotations.SerializedName

class IzinInstruktur (
    @SerializedName("ID_IZIN_INSTRUKTUR") val ID_IZIN_INSTRUKTUR: Int?,
    @SerializedName("ID_INSTRUKTUR") val ID_INSTRUKTUR:String,
    @SerializedName("ID_INSTRUKTUR_PENGGANTI") val ID_INSTRUKTUR_PENGGANTI :String,
    @SerializedName("TANGGAL_PENGAJUAN_IZIN") val TANGGAL_PENGAJUAN_IZIN :String,
    @SerializedName("TANGGAL_IZIN") val TANGGAL_IZIN : String,
    @SerializedName("JAM_SESI_IZIN") val JAM_SESI_IZIN : String,
    @SerializedName("ALASAN_IZIN") val ALASAN_IZIN : String,
    @SerializedName("STATUS_KONFIRMASI") val STATUS_KONFIRMASI : String,
    @SerializedName("TANGGAL_KONFIRMASI") val TANGGAL_KONFIRMASI : String,
    @SerializedName("NAMA_INSTRUKTUR") val NAMA_INSTRUKTUR:String
    )