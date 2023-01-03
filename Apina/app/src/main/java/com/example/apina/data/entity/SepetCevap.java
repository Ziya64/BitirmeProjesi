package com.example.apina.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SepetCevap implements Serializable {
    @SerializedName("sepet_yemekler")
    private List<Sepet> sepet_yemekler;
    @SerializedName("success")
    private int success;

    public SepetCevap() {
    }

    public SepetCevap(List<Sepet> sepet_yemekler, int success) {
        this.sepet_yemekler = sepet_yemekler;
        this.success = success;
    }

    public List<Sepet> getSepet_yemekler() {
        return sepet_yemekler;
    }

    public void setSepet_yemekler(List<Sepet> sepet_yemekler) {
        this.sepet_yemekler = sepet_yemekler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
