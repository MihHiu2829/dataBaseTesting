package com.example.databasetesting;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class result implements Serializable {
    @SerializedName("id")
    public int id ;
    @SerializedName("tensanpham")
    public String tensanpham ;
    @SerializedName("hinhanh")
    public String hinhanh ;
}
