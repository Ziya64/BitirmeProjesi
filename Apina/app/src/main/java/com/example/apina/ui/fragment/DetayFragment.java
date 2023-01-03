package com.example.apina.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apina.R;
import com.example.apina.data.entity.Yemek;
import com.example.apina.databinding.FragmentDetayBinding;
import com.example.apina.ui.adapter.SepetAdapter;
import com.example.apina.ui.viewmodel.DetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetayFragment extends Fragment {
    private FragmentDetayBinding binding;
    private DetayViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false);

        binding.setDetayToolbar("Detay");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarDetay);

        DetayFragmentArgs bundle =DetayFragmentArgs.fromBundle(getArguments());
        Yemek gelenYemek =bundle.getYemekler();
        binding.setYemekNesnesi(gelenYemek);



        binding.setDetayFragment(this);

        return binding.getRoot();


    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetayViewModel.class);
    }
    public void sepetteYemekYukle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet,String kullanici_adi){
        viewModel.sepetteYemekYukle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);

    }

}