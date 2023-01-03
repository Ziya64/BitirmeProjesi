package com.example.apina.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class YemekCevap implements Serializable {
    @SerializedName("yemekler")
    private List<Yemek>yemekler;
    @SerializedName("success")
    private int success;

    public YemekCevap() {
    }

    public YemekCevap(int success, List<Yemek> yemekler) {
        this.success = success;
        this.yemekler = yemekler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<Yemek> getYemekler() {
        return yemekler;
    }

    public void setYemekler(List<Yemek> yemekler) {
        this.yemekler = yemekler;
    }
}
