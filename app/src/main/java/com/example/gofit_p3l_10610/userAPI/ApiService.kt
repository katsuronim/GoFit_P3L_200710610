package com.example.gofit_p3l_10610.userAPI

import retrofit2.Call
import retrofit2.http.*

public interface ApiService {
    @GET("api/users")
    open fun getUser(): Call<ResponseDataUser?>?

    @GET("api/members/{id}")
    open fun getMember(@Path("id") id:String?): Call<ResponseCreateMember?>?

    @GET("api/pegawais/{id}")
    open fun getMO(@Path("id") id:String?): Call<ResponseCreateMO?>?

    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("username") username:String,
        @Field("password") password:String):
            Call<ResponseCreate>?

    @FormUrlEncoded
    @POST("api/depositKelasMembers/getData")
    fun getDepositKelasMember(
        @Field("id_member") id_member:String):
            Call<ResponseCreateDepositKelasMember>?

    @FormUrlEncoded
    @POST("api/pegawais/forgotPassword")
    fun forgotPassword(
        @Field("email") email:String,
        @Field("username") username:String):
            Call<ResponseCreatePegawai>?
}