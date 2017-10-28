package com.example.abdul_wahab.networkok.interfaces;

import com.example.abdul_wahab.networkok.models.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Abdul-Wahab on 10/22/2017.
 */

public interface GitHubService {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);


}
