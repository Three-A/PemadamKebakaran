package com.example.yudha.pemadamkebakaran;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by yudha on 12/2/2017.
 */

public interface ApiInterface {
    //macam macam method, ada get, post
    //method Get
    //contoh dinamis
    //@GET("/emergency/pospemadam/{id}/{alamat}/{kota}")
    //Call<Pemadam> getPemadam(@Path("id") int angka, @Path("kota") String kota, @Path("alamat") String alamat);
    @GET("v1/emergency/pospemadam")
    //Call response default dari retrofit di dalam <> kelas yang mau di panggil
    //dengan kembali class object yang dipanggil
    Call<Pemadam> getPemadam(@Header("Authorization") String token);
}
