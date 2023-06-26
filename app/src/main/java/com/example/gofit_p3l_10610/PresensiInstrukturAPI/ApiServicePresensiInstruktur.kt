package com.example.gofit_p3l_10610.PresensiInstrukturAPI

import retrofit2.Call
import retrofit2.http.*

public interface ApiServicePresensiInstruktur {
//    @GET("p3l%20laravel%208/p3l_10610_7.4.33/public/api/users")
//    open fun getUser(): Call<ResponseDataUser?>?
//
    @FormUrlEncoded
    @POST("api/presensiInstrukturs/getData")
    fun getData(
        @Field("blank") blank:String):
            Call<ResponseCreateJadwalHarian>?

    @FormUrlEncoded
    @POST("api/presensiInstrukturs/getJadwalHarian")
    fun getJadwalHarian(
        @Field("blank") blank:String):
            Call<ResponseCreateJadwalHarian>?

    @FormUrlEncoded
    @POST("api/presensiInstrukturs")
    fun createData(
        @Field("id_instruktur") id_instruktur:String,
        @Field("id_jadwal_harian") id_jadwal_harian:String,
        @Field("jam_mulai") jam_mulai:String,
        ):
            Call<ResponseCreatePresensiInstruktur>?

    @FormUrlEncoded
    @POST("api/presensiInstrukturs/setSelesai")
    fun updateData(
        @Field("id_instruktur") id_instruktur:String,
        @Field("id_jadwal_harian") id_jadwal_harian:String,
        @Field("jam_selesai") jam_selesai:String,
    ):
            Call<ResponseCreatePresensiInstruktur>?

    @FormUrlEncoded
    @POST("api/presensiInstrukturs/getHistori")
    fun getHistori(
        @Field("id_instruktur") id_instruktur:String,
    ):
            Call<ResponseGetHistoriInstruktur>?
}