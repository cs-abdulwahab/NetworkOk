package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.abdul_wahab.networkok.models.Food;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://uol.mocklab.io/food")
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        // Response response = client.newCall(request).execute();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "onFailure() called with: call = [" + call + "], e = [" + e + "]");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: ");

                Gson gson = new Gson();
                Food []food = gson.fromJson(response.body().string(), Food[].class);

                ArrayList<Food > foodList  = new ArrayList<Food>(Arrays.asList(food)) ;

                String s = "";

            }
        });

        Log.d(TAG, "end of oncreate method: ");


    }
}
