package com.example.gofit_p3l_10610.PresensiInstrukturAPI

import com.google.gson.annotations.SerializedName

class JadwalHarian (
    @SerializedName("ID_JADWAL_HARIAN") val ID_JADWAL_HARIAN: String?,
    @SerializedName("TANGGAL_JADWAL_HARIAN") val TANGGAL_JADWAL_HARIAN:String,
    @SerializedName("ID_INSTRUKTUR") val ID_INSTRUKTUR :String,
    @SerializedName("STATUS_JADWAL_HARIAN") val STATUS_JADWAL_HARIAN :String,
    @SerializedName("ID_JADWAL_UMUM") val ID_JADWAL_UMUM :String,
    @SerializedName("hari_jadwal_umum") val hari_jadwal_umum :String,
    @SerializedName("jam_jadwal_umum") val jam_jadwal_umum :String,
    @SerializedName("nama_kelas") val nama_kelas :String,
    @SerializedName("nama_instruktur") val nama_instruktur :String
    )