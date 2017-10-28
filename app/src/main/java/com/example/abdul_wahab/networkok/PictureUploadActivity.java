package com.example.abdul_wahab.networkok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PictureUploadActivity extends AppCompatActivity {

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_upload);


        OkHttpClient client = new OkHttpClient();


/*
        RequestBody requestBody = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("file", imageName, RequestBody.create(MEDIA_TYPE_PNG, image))
                                .build();
*/

/*
        Request request = new Request.Builder().url("http://localhost:8080/v1/upload")
                .post(requestBody).build();
*/

//        Response response = client.newCall(request).execute();


    }
}




































