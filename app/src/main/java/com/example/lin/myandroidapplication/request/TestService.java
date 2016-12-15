package com.example.lin.myandroidapplication.request;

import com.example.lin.myandroidapplication.bean.CityBean;
import com.example.lin.myandroidapplication.bean.TestBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by lin on 2016/12/13.
 */
public interface TestService {

    @GET("apistore/weatherservice/citylist")
    Call<CityBean> getCity(@Header("apikey") String apikey, @Query("cityname") String cityName);

    @GET("articleCategory/findAll")
    Call<TestBean> getTest();
}
