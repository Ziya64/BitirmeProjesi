package com.example.apina.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apina.data.entity.Sepet;
import com.example.apina.data.entity.Yemek;
import com.example.apina.data.repo.YemekDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetayViewModel extends ViewModel {
private YemekDaoRepository yrepo;
    public MutableLiveData<List<Sepet>> sepetListesi =new MutableLiveData<>();

    @Inject
    public DetayViewModel(YemekDaoRepository yrepo){
        this.yrepo = yrepo;


    }

    public void sepetteYemekYukle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet,String kullanici_adi){
        yrepo.sepetteYemekYukle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);

    }

}
