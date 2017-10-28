package com.example.abdul_wahab.networkok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abdul_wahab.networkok.webservice.Faculty;
import com.example.abdul_wahab.networkok.webservice.FacultyService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecBDemoRetroActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_bdemo_retro);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.108/lara553/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FacultyService facultyService = retrofit.create(FacultyService.class);

        // Call<List<Faculty>> callFacultyList = facultyService.getFacultyList();
//        Call<Faculty> callFaculty = facultyService.getFaculty(31);

        Faculty f = new Faculty("faculty name ", "facultyEmail@email.com");



        // Call<Faculty> fac =  facultyService.saveFaculty("sample name", "sample email");


        Call<Faculty> fac = facultyService.saveFaculty(f);
/*        fac.enqueue(new Callback<Faculty>() {
            @Override
            public void onResponse(Call<Faculty> call, Response<Faculty> response) {

            }

            @Override
            public void onFailure(Call<Faculty> call, Throwable t) {

            }
        });
*/


        /*

  callFaculty.enqueue(new Callback<Faculty>() {
      @Override
      public void onResponse(Call<Faculty> call, Response<Faculty> response) {

      }

      @Override
      public void onFailure(Call<Faculty> call, Throwable t) {

      }
  });
*/



        /*callFacultyList.enqueue(new Callback<List<Faculty>>() {
            @Override
            public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {

                List<Faculty> faculties = response.body();

                String s = "";
                Log.d("MTAG", "onResponse: ");

            }

            @Override
            public void onFailure(Call<List<Faculty>> call, Throwable t) {

                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");


            }
        });
*/

    }
}
