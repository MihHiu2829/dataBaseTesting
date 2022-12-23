package com.example.databasetesting;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoaiSP implements Serializable {
    @SerializedName("success")
    public boolean success ;
    @SerializedName("message")
    public String message ;
    @SerializedName("result")
    public List<result> result ;


}
