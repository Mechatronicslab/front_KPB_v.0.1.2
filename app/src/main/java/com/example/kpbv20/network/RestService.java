package com.example.kpbv20.network;


//import com.example.app4g.App;
//import com.example.app4g.R;
//import com.example.app4g.server.AppController;


import com.example.kpbv20.App;
import com.example.kpbv20.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {
    private static final String BASK_URL = App.getApplication().getString(R.string.end_point);
    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASK_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

//    public static RestService getAPIService(){
//        return RetrofitClient.getClient(BASK_URL).create(RestService.class);
//
//    }
}
