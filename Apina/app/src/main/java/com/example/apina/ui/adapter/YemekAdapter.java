package com.example.apina.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apina.R;
import com.example.apina.data.entity.Yemek;
import com.example.apina.databinding.CardTasarimBinding;
import com.example.apina.ui.fragment.AnasayfaFragmentDirections;
import com.example.apina.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ConcurrentModificationException;
import java.util.List;

public class YemekAdapter extends RecyclerView.Adapter<YemekAdapter.CardTAsarimTutucu> {
    private Context yContext;
    private List<Yemek> YemeklerListe;
    private AnasayfaViewModel viewModel;


    public YemekAdapter(Context yContext, List<Yemek> yemeklerListe, AnasayfaViewModel viewModel) {
        this.yContext = yContext;
        YemeklerListe = yemeklerListe;
        this.viewModel = viewModel;
    }



    public class CardTAsarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding binding;

        public CardTAsarimTutucu( CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    @NonNull
    @Override
    public CardTAsarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(yContext), R.layout.card_tasarim,parent,false);
        return new CardTAsarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTAsarimTutucu holder, int position) {
        Yemek yemek =YemeklerListe.get(position);
        CardTasarimBinding t =holder.binding;

        t.textViewBilgi.setText(yemek.getYemek_adi()+"  "+String.valueOf(yemek.getYemek_fiyat())+"tl  ");
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/"+yemek.getYemek_resim_adi()).into(t.imageView);
        t.imageView.setOnClickListener(view -> {
            Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/"+yemek.getYemek_resim_adi()).into(t.imageView);
        });
       t.satirCard.setOnClickListener(view -> {
           AnasayfaFragmentDirections.DetayGecis gecis=
                   AnasayfaFragmentDirections.detayGecis(yemek);
           Navigation.findNavController(view).navigate(gecis);
       });



    }

    @Override
    public int getItemCount() {
        return YemeklerListe.size() ;
    }


}
