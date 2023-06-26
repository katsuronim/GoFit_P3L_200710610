package com.example.gofit_p3l_10610.BookingKelasAPI

import retrofit2.Call
import retrofit2.http.*

interface ApiServiceBookingKelas {
    @GET("api/bookingPresensiKelas")
    fun getBookingKelas(): Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas/getJadwalHarian")
    fun getJadwalHarian(@Field("blank") blank:String?,):Call<ResponseCreateJadwalHarian>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas/getDataBooking")
    fun getDataBooking(
        @Field("id_member") idMember:String?
    ):Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas/getDataBookingInstruktur")
    fun getDataBookingInstruktur(
        @Field("id_instruktur") idInstruktur:String?
    ):Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas/getHistori")
    fun getHistori(
        @Field("id_member") id_member:String?,
        @Field("tanggal_mulai") tanggal_mulai:String?,
        @Field("tanggal_akhir") tanggal_akhir:String?,
        ):Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas")
    fun createData(
        @Field("id_member") idMember:String?,
        @Field("id_jadwal_harian") idJadwalHarian:String?
    ):Call<ResponseCreateJadwalHarian>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas/setHadir")
    fun setHadir(
        @Field("id_member") idMember:String?,
        @Field("id_jadwal_harian") idJadwalHarian:String?,
        @Field("jam_presensi_kelas") jam:String?,
        ):Call<ResponseCreateJadwalHarian>

    @FormUrlEncoded
    @POST("api/bookingPresensiKelas/setTidakHadir")
    fun setTidakHadir(
        @Field("id_member") idMember:String?,
        @Field("id_jadwal_harian") idJadwalHarian:String?,
        @Field("jam_presensi_kelas") jam:String?,
    ):Call<ResponseCreateJadwalHarian>

    @DELETE("api/bookingPresensiKelas/{id}")
    fun deleteData(@Path("id") id: String?
    ): Call<ResponseCreateBookingKelas>
}