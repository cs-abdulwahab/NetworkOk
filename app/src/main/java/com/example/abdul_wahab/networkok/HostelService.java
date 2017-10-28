package com.example.abdul_wahab.networkok;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Abdul-Wahab on 10/25/2017.
 */

public interface HostelService {

    @GET("hostel")
    Call<List<Hostel>> getHostels();

    @GET("hostel/{hostelid}")
    Call<Hostel> getHostel(@Path("hostelid") int id);


    @POST("hostel")
    @FormUrlEncoded
    Call<Hostel> saveHostel(@Field("name") String fullname,
                            @Field("address") String address,
                            @Field("capacity") int capacity
    );




}
