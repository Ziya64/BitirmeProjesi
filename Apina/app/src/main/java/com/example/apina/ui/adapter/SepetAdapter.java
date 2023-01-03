package com.example.apina.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apina.R;
import com.example.apina.data.entity.Sepet;
import com.example.apina.data.entity.Yemek;
import com.example.apina.databinding.SepetTasarimBinding;
import com.example.apina.databinding.SepetTasarimBindingImpl;
import com.example.apina.ui.viewmodel.SepetViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.SepetTasarimTutucu>{
    private Context sContext;
    private List<Sepet> sepetListesi;
    private SepetViewModel viewModel;

    public SepetAdapter(Context sContext, List<Sepet> sepetListesi, SepetViewModel viewModel) {
        this.sContext = sContext;
        this.sepetListesi = sepetListesi;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public SepetTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SepetTasarimBinding binding=
                DataBindingUtil.inflate(LayoutInflater.from(sContext), R.layout.sepet_tasarim,parent,false);
        return new SepetTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SepetTasarimTutucu holder, int position) {
        Sepet sepet =sepetListesi.get(position);
        SepetTasarimBinding s =holder.binding;
        s.textViewAdet.setText(String.valueOf(sepet.getYemek_siparis_adet()));
        s.textViewFiyati.setText(String.valueOf(sepet.getYemek_fiyat())+"tl");
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle"+sepet.getYemek_resim_adi()).into(s.imageViewYemekSepeti);
        s.imageViewYemekSepeti.setOnClickListener(view -> {
            Picasso.get().load("http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir"+sepet.getYemek_resim_adi()).into(s.imageViewYemekSepeti);





        });

    }

    @Override
    public int getItemCount() {
        return sepetListesi.size();
    }

    public class SepetTasarimTutucu extends RecyclerView.ViewHolder{
            private SepetTasarimBinding binding;


            public SepetTasarimTutucu(SepetTasarimBinding binding){
                super(binding.getRoot());
                this.binding = binding;
            }
        }




}
