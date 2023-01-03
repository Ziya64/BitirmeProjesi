package com.example.apina.retrofit;

import com.example.apina.data.entity.CRUDCevap;
import com.example.apina.data.entity.Sepet;
import com.example.apina.data.entity.Yemek;
import com.example.apina.data.entity.YemekCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface YemekDao {
         //http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php
        //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php
        //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php


        @GET("yemekler/tumYemekleriGetir.php")
        Call<YemekCevap> yemeklerYukle();

        @POST("yemekler/sepettekiYemekleriGetir.php")
        @FormUrlEncoded
        Call<Sepet> sepettenYemekleriGetir(
                @Field("kullanici_adi")String aramaKelimesi);

        @POST("yemekler/sepeteYemekEkle.php")
        @FormUrlEncoded
        Call<CRUDCevap> sepetteYemekYukle(
                @Field("yemek_adi") String yemek_adi,
                @Field("yemek_resim_adi") String yemek_resim_adi,
                @Field("yemek_fiyat") int yemek_fiyat,
                @Field("yemek_siparis_adet") int yemek_siparis_adet,
                @Field("kullanici_adi") String kullanici_adi
        );
        @POST("yemekler/sepettenYemekSil.php")
        @FormUrlEncoded
        Call<CRUDCevap> sepetteYemekSil (
                @Field("sepet_yemek_id") int sepet_yemek_id,
                @Field("kullanici_adi") String kullanici_adi
        );



}
