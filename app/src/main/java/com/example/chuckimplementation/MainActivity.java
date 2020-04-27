package com.example.chuckimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chuckimplementation.api_call.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//First add the dependencies for Chuck and Retrofit
   //for chuck
      //debugImplementation 'com.readystatesoftware.chuck:library:1.1.0'
      //releaseImplementation 'com.readystatesoftware.chuck:library-no-op:1.1.0'

   //for Retrofit
      /*implementation 'com.squareup.retrofit2:retrofit:2.7.0'
       implementation 'com.squareup.retrofit2:converter-gson:2.7.0'
       implementation 'com.google.code.gson:gson:2.8.5'*/

// Now paste ApiClient.class into your application
public class MainActivity extends AppCompatActivity {

    private ApiClient apiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating instance of ApiClient
        apiClient=new ApiClient(this);

        findViewById(R.id.callApiBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callingApi();
            }
        });
    }

    private void callingApi() {

        Call<YourModelClass> allStoresModelCall=apiClient.mediatorInterface.getAllStores(0);

        allStoresModelCall.enqueue(new Callback<YourModelClass>() {
            @Override
            public void onResponse(Call<YourModelClass> call, Response<YourModelClass> response) {
                Log.i("retro","success");
            }

            @Override
            public void onFailure(Call<YourModelClass> call, Throwable t) {
                Log.i("retro","fail");
            }
        });

    }
}
