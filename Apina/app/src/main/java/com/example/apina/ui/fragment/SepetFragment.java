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
import com.example.apina.databinding.FragmentSepetBinding;
import com.example.apina.ui.adapter.SepetAdapter;
import com.example.apina.ui.viewmodel.SepetViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {
    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false);


        binding.setSepeteToolBar("Sepet");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarSepet);
            binding.setSepetFragment(this);



        viewModel.sepetListesi.observe(getViewLifecycleOwner(),sepets -> {
            SepetAdapter adapter =new SepetAdapter(requireContext(),sepets,viewModel);
            binding.setSepetAdapter(adapter);
        });

        return binding.getRoot();



    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);
    }


}