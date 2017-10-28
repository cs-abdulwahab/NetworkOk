package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.abdul_wahab.networkok.interfaces.MockLabService;
import com.example.abdul_wahab.networkok.models.Food;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";


    @Subscribe(threadMode = ThreadMode.MAIN)
    void FoodItemReceived(FoodEvent foodEvent) {

        Log.d(TAG, "FoodItemReceived: ");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        EventBus.getDefault().register(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://uol.mocklab.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MockLabService service = retrofit.create(MockLabService.class);

        Call<List<Food>> foodList = service.getFood();

        foodList.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");

                List<Food> foods = response.body();

                EventBus.getDefault().post(new FoodEvent(foods));

                String s = "";


            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });


    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
