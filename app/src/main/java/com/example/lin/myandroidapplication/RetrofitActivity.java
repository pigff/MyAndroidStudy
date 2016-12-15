package com.example.lin.myandroidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lin.myandroidapplication.bean.CityBean;
import com.example.lin.myandroidapplication.request.TestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mTextView = (TextView) findViewById(R.id.retrofit_tv_01);

        initCon();
    }

    private void initCon() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestService service = retrofit.create(TestService.class);
        Call<CityBean> call = service.getCity("3270592d1293b1e9a15eabc51ff2b23f", "朝阳");
        call.enqueue(new Callback<CityBean>() {
            @Override
            public void onResponse(Call<CityBean> call, Response<CityBean> response) {
                CityBean cityBean = response.body();
                mTextView.setText(cityBean.toString());

            }

            @Override
            public void onFailure(Call<CityBean> call, Throwable t) {

            }
        });
//        Call<TestBean> call = service.getTest();
//        call.enqueue(new Callback<TestBean>() {
//            @Override
//            public void onResponse(Call<TestBean> call, Response<TestBean> response) {
//                TestBean testBean = response.body();
//                mTextView.setText(testBean.toString());
//            }
//
//            @Override
//            public void onFailure(Call<TestBean> call, Throwable t) {
//
//            }
//        });
    }


}
