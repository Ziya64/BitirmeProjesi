package com.example.apina.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CRUDCevap implements Serializable {
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private String message ;

    public CRUDCevap() {
    }

    public CRUDCevap(int success, String message) {
        this.success = success;
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
