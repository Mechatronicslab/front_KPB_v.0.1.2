package com.example.kpbv20.network;



import com.example.kpbv20.features.signin.model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NetworkService {

    @POST("users/signin")
    Call<LoginResponse> signin();

//    @FormUrlEncoded
//    @POST("cart/create")
//    Call<RutResponse> createCart(@FieldMap Map<String, Object> params);
//
//    @FormUrlEncoded
//    @POST("transaksi")
//    Call<CommonResponse> checkout(@FieldMap Map<String, Object> data);
//
//    @GET("barang")
//    Call<RutResponse> showProduct();
//
//    @GET("cart/{nik}")
//    Call<Cart> getCart(@Path("nik") String nik);
//
//    @GET("profile/{nik}")
//    Call<ProfileResponse> getProfilePetani(@Path("nik") String nik);
//
//    @GET("saldo/{nik}")
//    Call<Saldo> getSaldo(@Path("nik") String nik);
//
//    @FormUrlEncoded
//    @POST("transaksiRut")
//    Call<CommonRespon> createRut(@FieldMap Map<String, Object> params);
//
//    @FormUrlEncoded
//    @PUT("petaniedit/{nik}")
//    Call<LoginResponse> updateProfile(@Path("nik") String nik, @FieldMap Map<String, Object> data);
//
//    @GET("rutpetani/{nik}")
//    Call<com.app.app4g.features.rut.model.RutResponse> getRut(@Path("nik") String nik);
//
//    @GET("kabupaten/{id}")
//    Call<AreaResponse> getKab(@Path("id") String id);
//
//    @GET("kecamatan/{id}")
//    Call<AreaResponse> getKec(@Path("id") String id);
//
//    @GET("desa/{id}")
//    Call<AreaResponse> getDesa(@Path("id") String id);
//
//    @GET("subsektor")
//    Call<AreaResponse> getSubsektor();
//
//    @GET("komoditasbysub/{idSub}")
//    Call<AreaResponse> getKomoditas(@Path("idSub") String idSub);
//
//    @GET("cekversion/{id}")
//    Call<CommonRespon> cekVersion(@Path("id") String id);
//
//    @POST("users/signupandcreate")
//    Call<CommonRespon> daftarPetani(@Body RegistModel registModel);
}
