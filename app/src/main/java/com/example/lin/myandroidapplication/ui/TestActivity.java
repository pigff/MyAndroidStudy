package com.example.lin.myandroidapplication.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.lin.myandroidapplication.App;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.net.CameraBean;
import com.example.lin.myandroidapplication.data.net.CameraCategoryBean;
import com.example.lin.myandroidapplication.network.TestService;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class TestActivity extends AppCompatActivity {

    private TestService mTestService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView textView = (TextView) findViewById(R.id.tv_test1);
        String baseurl = "http://java.fjrcloud.com/country/";
        String[] strings = {"xixi", "haha"};
        Integer[] integers = {6, 7, 8};

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().build())
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mTestService = retrofit.create(TestService.class);
        mTestService.getCameraCategory(4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CameraCategoryBean>() {
                    @Override
                    public void call(CameraCategoryBean cameraCategoryBean) {
                        Log.d("TestActivity", cameraCategoryBean.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
        Observable.from(integers)
                .flatMap(new Func1<Integer, Observable<CameraBean>>() {
                    @Override
                    public Observable<CameraBean> call(Integer integer) {
                        return mTestService.getCamera(integer);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CameraBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CameraBean cameraBean) {
                        Log.d("TestActivity", cameraBean.toString());
                    }
                });


        Drawable drawable = new IconicsDrawable(App.getInstance())
                .icon(MaterialDesignIconic.Icon.gmi_mood)
                .color(ContextCompat.getColor(App.getInstance(), R.color.colorAccent))
                .sizeDp(100);
        textView.setCompoundDrawables(drawable, null, null, null);
    }
}
