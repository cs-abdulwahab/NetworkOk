package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abdul_wahab.networkok.webservice.FacultyServiceRESTClient;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class InterceptorActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interceptor);


       // FacultyServiceRESTClient.getInstance();



        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        /*OkHttpClient client = new OkHttpClient.Builder()

                .build();
*/



        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();


        Request request = new Request.Builder()
                .url("http://192.168.56.1/lara553/public/api/hostel/2")
                .get()
                .build();


        /*okHttpClientBuilder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Authorization", "auth-value") // <-- this is the important line
                        .addHeader("auth", "auth"); // <-- this is the important line

                Request request = requestBuilder.build();
                return chain.proceed(request);


            }
        });
*/

        okHttpClientBuilder.addInterceptor(logging);


        OkHttpClient client = okHttpClientBuilder.build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


            }
        });


    }
}
