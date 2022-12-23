package com.example.databasetesting;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {
    @GET("getloaisp.php")
    Call<LoaiSP>getSP();
}
