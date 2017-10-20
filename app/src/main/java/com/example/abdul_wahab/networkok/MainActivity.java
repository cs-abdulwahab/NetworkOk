package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abdul_wahab.networkok.models.Food;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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


//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    void fun(CustomEvent customEvent) {
//        Log.d(TAG, "fun: ");
//    }


    // ThreadMode MAIN (UI Thread )
    @Subscribe(threadMode = ThreadMode.MAIN)
    void test(CustomEvent customEvent) {

        Log.d(TAG, "test: custom event = " + customEvent.json);

        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        Log.d(TAG, "test: " + txtMessage.getText().toString());

        txtMessage.setText(customEvent.json);

        Log.d(TAG, "test: update " + txtMessage.getText().toString());

    }


    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        Button btnFetch = (Button) findViewById(R.id.btnFetch);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OkHttpClient client = new OkHttpClient();
                Request req = new Request.Builder()
                        .get()
                        .url("http://uol.mocklab.io/food")
                        .build();
                client.newCall(req).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure() called with: call = [" + call + "], e = [" + e + "]");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        //to update the txtMessage
                        // Cannot Update like this
                        /*
                            TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
                            txtMessage.setText(response.body().string());
                        */

                        EventBus.getDefault().post(new CustomEvent(response.body().string()));

                    }
                });


            }
        });


        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://uol.mocklab.io/food")
                .get()
                .addHeader("cache-control", "no-cache")
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.d(TAG, "onFailure() called with: call = [" + call + "], e = [" + e + "]");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");


                Gson gson = new Gson();
                Food[] food = gson.fromJson(response.body().string(), Food[].class);

                //ArrayList<Food>    Arrays.asList(food);

                ArrayList<Food> foodList = new ArrayList<Food>(Arrays.asList(food));

                //           EventBus.getDefault().post(new CustomEvent());


                String s = "";
            }
        });



/*
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
*/

        Log.d(TAG, "end of oncreate method: ");


    }
}
