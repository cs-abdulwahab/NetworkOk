package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HostelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.101/lara553/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HostelService hostelService = retrofit.create(HostelService.class);


 Call<Hostel>  callhostel  = hostelService.saveHostel("My Hostel","My hostel address",123);

        callhostel.enqueue(new Callback<Hostel>() {
            @Override
            public void onResponse(Call<Hostel> call, Response<Hostel> response) {

            }

            @Override
            public void onFailure(Call<Hostel> call, Throwable t) {

            }
        });




    }
}





