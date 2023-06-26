package com.example.gofit_p3l_10610.izinInstrukturAPI

import retrofit2.Call
import retrofit2.http.*

public interface ApiServiceIzin {
    @GET("api/izinInstrukturs/{cari}")
    fun getIzin(@Path("cari") cari: String?): Call<ResponseCreateIzinInstruktur>

    @FormUrlEncoded
    @POST("api/izinInstrukturs/search/{cari}")
    fun search(
        @Field("cari") cari:String?
    ): Call<ResponseCreateIzinInstruktur>

    @GET("api/instrukturs/{id}")
    fun getInstruktur(
        @Path("id") id:String?
    ): Call<ResponseCreateInstruktur>

    @FormUrlEncoded
    @POST("api/izinInstrukturs")
    fun createData(
        @Field("id_instruktur") idInstruktur:String?,
        @Field("id_instruktur_pengganti") idInstrukturPengganti: String,
        @Field("tanggal_izin") tanggalIzin:String?,
        @Field("jam_sesi_izin") jamSesiIzin:String?,
        @Field("alasan_izin") alasanIzin:String?
    ):Call<ResponseCreateIzinInstruktur>

    @FormUrlEncoded
    @POST("api/izinInstrukturs/getId")
    fun getIdInstruktur(@Field("id_instruktur") idInstruktur:String?,):Call<ResponseCreateIzinInstruktur>
}