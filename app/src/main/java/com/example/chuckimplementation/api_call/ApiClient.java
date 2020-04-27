package com.example.chuckimplementation.api_call;

import android.content.Context;

import com.example.chuckimplementation.api_call.api_interfaces.MediatorInterface;
import com.google.gson.Gson;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Context context;
    //replace MediatorInterface with your interface here
    public MediatorInterface mediatorInterface;
    //paste your base url here
    private final String BASE_URL="yourBaseUrl";

    public ApiClient(Context context) {
        this.context = context;
        configure();
    }

    private void configure()
    {
        OkHttpClient okHttpClient= new OkHttpClient.Builder()
                //Here new ChuckInterceptor(context) integrates chuck in our app
                .addInterceptor(new ChuckInterceptor(context))
                .build();
        Retrofit.Builder retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);

        mediatorInterface=retrofit.baseUrl(BASE_URL).build().create(MediatorInterface.class);

    }
}
