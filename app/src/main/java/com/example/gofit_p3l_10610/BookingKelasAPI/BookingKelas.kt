package com.example.gofit_p3l_10610.BookingKelasAPI

import com.google.gson.annotations.SerializedName

class BookingKelas (
    @SerializedName("NOMOR_STRUK") val NOMOR_STRUK: String?,
    @SerializedName("ID_MEMBER") val ID_MEMBER:String,
    @SerializedName("ID_JADWAL_HARIAN") val ID_JADWAL_HARIAN :String,
    @SerializedName("TANGGAL_BOOKING_KELAS") val TANGGAL_BOOKING_KELAS :String,
    @SerializedName("JENIS_BOOKING_PRESENSI") val JENIS_BOOKING_PRESENSI :String,
    @SerializedName("SISA_DEPOSIT") val SISA_DEPOSIT :String,
    @SerializedName("STATUS_PRESENSI_KELAS") val STATUS_PRESENSI_KELAS : String,
    @SerializedName("JAM_PRESENSI_KELAS") val JAM_PRESENSI_KELAS : String,
    @SerializedName("HARI_JADWAL_UMUM") val HARI_JADWAL_UMUM : String,
    @SerializedName("TANGGAL_JADWAL_HARIAN") val TANGGAL_JADWAL_HARIAN : String,
    @SerializedName("NAMA_KELAS") val NAMA_KELAS : String,
    @SerializedName("NAMA_MEMBER") val NAMA_MEMBER : String,
    )