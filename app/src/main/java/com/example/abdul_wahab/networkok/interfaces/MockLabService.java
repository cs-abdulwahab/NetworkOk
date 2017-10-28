package com.example.abdul_wahab.networkok.interfaces;

import com.example.abdul_wahab.networkok.models.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abdul-Wahab on 10/22/2017.
 */

public interface MockLabService {

    @GET("/food")
    Call<List<Food>> getFood();


}
