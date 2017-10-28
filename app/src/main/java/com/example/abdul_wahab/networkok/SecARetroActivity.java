package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abdul_wahab.networkok.webservice.Faculty;
import com.example.abdul_wahab.networkok.webservice.FacultyService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecARetroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_aretro);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.101/lara553/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FacultyService facultyService = retrofit.create(FacultyService.class);

         Call<Faculty>  faculty = facultyService.saveFaculty("Tayyab Rasheed","rasheed@rasheed.com");

        faculty.enqueue(new Callback<Faculty>() {
            @Override
            public void onResponse(Call<Faculty> call, Response<Faculty> response) {

            }

            @Override
            public void onFailure(Call<Faculty> call, Throwable t) {

            }
        });








/*
        Call<Faculty> Callfaculty = facultyService.getFaculty(114);
        Callfaculty.enqueue(new Callback<Faculty>() {
            @Override
            public void onResponse(Call<Faculty> call, Response<Faculty> response) {

            }

            @Override
            public void onFailure(Call<Faculty> call, Throwable t) {

            }
        });
*/

    }
}
