package com.example.apina.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apina.data.entity.Yemek;
import com.example.apina.data.repo.YemekDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    private YemekDaoRepository yrepo;
    public MutableLiveData<List<Yemek>> yemekListesi =new MutableLiveData<>();
@Inject
    public AnasayfaViewModel(YemekDaoRepository yrepo){
         this.yrepo = yrepo;
        YemekleriYukle();
        yemekListesi = yrepo.getYemekListesi();

    }



    public void YemekleriYukle(){
    yrepo.yemeklerYukle();
    }

}
