package com.example.abdul_wahab.networkok.webservice;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Abdul-Wahab on 10/24/2017.
 */

public interface FacultyService {

    @GET("faculty")
    Call<List<Faculty>> getFacultyList();

    @GET("faculty/{faculty}")
    Call<Faculty> getFaculty(@Path("faculty") int id);

    @POST("faculty")
    @FormUrlEncoded
    Call<Faculty> saveFaculty(@Field("name") String fullname, @Field("email") String email);

    @POST("faculty")
    Call<Faculty> saveFaculty(@Body Faculty f);
/*
    @DELETE
    Call<Faculty> deleteFaculty(@Query(value = "id", encoded = true) int id);
*/

}
