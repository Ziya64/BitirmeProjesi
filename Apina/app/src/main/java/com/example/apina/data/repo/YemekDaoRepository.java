package com.example.apina.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.apina.data.entity.CRUDCevap;
import com.example.apina.data.entity.Sepet;
import com.example.apina.data.entity.Yemek;
import com.example.apina.data.entity.YemekCevap;
import com.example.apina.retrofit.YemekDao;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemekDaoRepository {
    private MutableLiveData<List<Yemek>> yemekListesi;
    private YemekDao ydao;
    @Inject
    public YemekDaoRepository(YemekDao ydao){
        this.ydao=ydao;
        yemekListesi=new MutableLiveData<>();
    }
    public MutableLiveData<List<Yemek>> getYemekListesi(){
        return yemekListesi;
    }



    public void yemeklerYukle( ){
        ydao.yemeklerYukle().enqueue(new Callback<YemekCevap>() {
            @Override
            public void onResponse(Call<YemekCevap> call, Response<YemekCevap> response) {
            List<Yemek> yemekList =response.body().getYemekler();
            yemekListesi.setValue(yemekList);

            }

            @Override
            public void onFailure(Call<YemekCevap> call, Throwable t) {

            }
        });

    }

    public void sepetteYemekYukle(String yemek_adi,String yemek_resim_adi ,int yemek_fiyat,int yemek_siparis_adet,String kullanici_adi){
        ydao.sepetteYemekYukle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {

            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });

    }

    public void sepetteYemekSil(int sepet_yemek_id,String kullanici_adi){
        ydao.sepetteYemekSil(sepet_yemek_id,kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                    yemeklerYukle();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });

    }
    public void sepettenYemekleriGetir(String kullanici_adi){
        ydao.sepettenYemekleriGetir(kullanici_adi).enqueue(new Callback<Sepet>() {
            @Override
            public void onResponse(Call<Sepet> call, Response<Sepet> response) {
                yemeklerYukle();
            }

            @Override
            public void onFailure(Call<Sepet> call, Throwable t) {

            }
        });

    }










}
