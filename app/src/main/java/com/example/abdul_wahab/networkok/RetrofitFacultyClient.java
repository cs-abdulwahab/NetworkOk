package com.example.abdul_wahab.networkok;

import com.example.abdul_wahab.networkok.webservice.FacultyService;

import retrofit2.Retrofit;

/**
 * Created by Abdul-Wahab on 10/26/2017.
 */

public class RetrofitFacultyClient {
    private static FacultyService ourInstance;

    public static FacultyService getInstance() {

        if (ourInstance == null) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.56.1/lara553/public/api/hostel/2")
                    .build();

            ourInstance = retrofit.create(FacultyService.class);
        }

        return ourInstance;


    }

    private RetrofitFacultyClient() {
    }
}
