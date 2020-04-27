package com.example.chuckimplementation.api_call.api_interfaces;




import com.example.chuckimplementation.YourModelClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MediatorInterface {
    @GET("yourUrl") //paste your url here

    //paste your model class here
    Call<YourModelClass> getAllStores(@Query("page") int page);

}
