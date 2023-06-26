package com.example.gofit_p3l_10610.PresensiInstrukturAPI

import com.google.gson.annotations.SerializedName

class HistoriInstruktur(
    @SerializedName("ID_PRESENSI_INSTRUKTUR") val ID_PRESENSI_INSTRUKTUR: String?,
    @SerializedName("ID_INSTRUKTUR") val ID_INSTRUKTUR:String,
    @SerializedName("ID_JADWAL_HARIAN") val ID_JADWAL_HARIAN :String,
    @SerializedName("JAM_MULAI") val JAM_MULAI :String,
    @SerializedName("JAM_SELESAI") val JAM_SELESAI :String,
    @SerializedName("KETERLAMBATAN") val KETERLAMBATAN :String,
    @SerializedName("DURASI_KELAS") val DURASI_KELAS :String,
    @SerializedName("STATUS") val STATUS :String,
    @SerializedName("NAMA_KELAS") val NAMA_KELAS :String,
    @SerializedName("HARI_JADWAL_UMUM") val HARI_JADWAL_UMUM :String,
    @SerializedName("TANGGAL_JADWAL_HARIAN") val TANGGAL_JADWAL_HARIAN :String,
    )