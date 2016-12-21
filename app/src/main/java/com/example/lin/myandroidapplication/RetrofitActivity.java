package com.example.lin.myandroidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.lin.myandroidapplication.bean.TextJokeResponse;
import com.example.lin.myandroidapplication.request.TestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mTextView = (TextView) findViewById(R.id.retrofit_tv_01);

        initCon();
    }

    private void initCon() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://apis.baidu.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://route.showapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestService service = retrofit.create(TestService.class);
        String appid = "29056";
        String sign = "307d7e2831614e11a510b57f5e55f4e6";
        String page = "1";
        String result = "20";
        Call<TextJokeResponse> call = service.getTextJokeData("341-1", appid, sign, page, result);
        call.enqueue(new Callback<TextJokeResponse>() {
            @Override
            public void onResponse(Call<TextJokeResponse> call, Response<TextJokeResponse> response) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < response.body().getShowapi_res_body().getContentlist().size(); i++) {
                    builder.append(response.body().getShowapi_res_body().getContentlist().get(i).getTitle());
                }
                mTextView.setText(builder);
            }

            @Override
            public void onFailure(Call<TextJokeResponse> call, Throwable t) {
                Log.d(TAG, "failure");
            }
        });
//        Call<CityBean> call = service.getCity("3270592d1293b1e9a15eabc51ff2b23f", "朝阳");
//        call.enqueue(new Callback<CityBean>() {
//            @Override
//            public void onResponse(Call<CityBean> call, Response<CityBean> response) {
//                CityBean cityBean = response.body();
//                mTextView.setText(cityBean.toString());
//
//            }
//
//            @Override
//            public void onFailure(Call<CityBean> call, Throwable t) {
//
//            }
//        });
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
