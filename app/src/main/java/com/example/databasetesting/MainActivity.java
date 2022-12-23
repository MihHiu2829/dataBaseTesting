package com.example.databasetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
        API api ;
        String a = "xin chao moi nguoi" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        Retrofit rs = new Retrofit.Builder().baseUrl(Utils.base_URL)
                .addConverterFactory(GsonConverterFactory.create()).build() ;
        api = rs.create(API.class) ;

      api.getSP().enqueue(new Callback<LoaiSP>() {
          @Override
          public void onResponse(Call<LoaiSP> call, Response<LoaiSP> response) {
              if(response.code() == 200 || response.code() == 201)
              {
                  SuccessFul(response.body()) ;
              }
          }

          @Override
          public void onFailure(Call<LoaiSP> call, Throwable t) {

          }
      });

    }

    private void SuccessFul(LoaiSP body) {
        try {
            Toast.makeText(this, "Vaof dc success", Toast.LENGTH_SHORT).show();
            Log.e(MainActivity.class.getName(),body.result.get(0).hinhanh) ;
             View v = getLayoutInflater().inflate(R.layout.activity_main,null) ;
            Glide.with(this).load("https://images.unsplash.com/photo-1669422986501-2650e9cbd855?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY3MDY4MDUwMQ&ixlib=rb-4.0.3&q=80&w=1080")
                    .into((ImageView)v.findViewById(R.id.tv_test)) ;
    } catch (Exception e) {
                e.printStackTrace();
        }
    }

    }