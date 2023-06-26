package com.example.gofit_p3l_10610.BookingGymAPI

import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateBookingKelas
import com.example.gofit_p3l_10610.BookingKelasAPI.ResponseCreateJadwalHarian
import retrofit2.Call
import retrofit2.http.*

public interface ApiServiceGym {
    @GET("api/bookingPresensiGyms")
    open fun getBookingGym(): Call<ResponseCreateBookingPresensiGym?>?

    @FormUrlEncoded
    @POST("api/bookingPresensiGyms/getData")
    fun getBookingUser(@Field("id") id:String?,):Call<ResponseCreateBookingPresensiGym>

    @FormUrlEncoded
    @POST("api/bookingPresensiGyms")
    fun createData(
        @Field("id_member") id_member:String?,
        @Field("tanggal_yang_dibooking") tanggal_yang_dibooking:String?,
        @Field("sesi_dibooking") sesi_dibooking:String?,
    ):Call<ResponseCreateBookingPresensiGym>

    @FormUrlEncoded
    @POST("api/bookingPresensiGyms/getHistori")
    fun getHistori(
        @Field("id_member") id_member:String?,
        @Field("tanggal_mulai") tanggal_mulai:String?,
        @Field("tanggal_akhir") tanggal_akhir:String?
        ):Call<ResponseCreateBookingPresensiGym>

    @DELETE("bookingPresensiGyms/{id}")
    fun deleteData(@Path("id") id: String?
    ): Call<ResponseCreateBookingPresensiGym>
}