package com.pale.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> submitLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("kolam")
    Call<ResponseBody> getDataKolam(
            @Field("id") String id,
            @Field("id_kolam") String idkolam,
            @Field("nama_kolam") String namakolam,
            @Field("pemilik") String namapemilik
    );
}
