package com.example.lin.myandroidapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneStateListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.List;

public class LoadTestActivity extends AppCompatActivity {

    private List<String> mImgUrls;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private ImgAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_test);
        initData();
        initView();

    }

    private void initData() {
        mImgUrls = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mImgUrls.add("http://img2.imgtn.bdimg.com/it/u=4207984293,3460265301&fm=23&gp=0.jpg");
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.load_test_rv);
        mProgressBar = (ProgressBar) findViewById(R.id.pg);
        findViewById(R.id.hide_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                //去掉虚拟按键全屏显示
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        });

        findViewById(R.id.show_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                //去掉虚拟按键全屏显示
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        });
        mAdapter = new ImgAdapter(R.layout.rv_img_item, mImgUrls);
        mRecyclerView.setHasFixedSize(true);
        PhoneStateListener listener = new PhoneStateListener();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setVisibility(View.GONE);
                            mRecyclerView.setVisibility(View.VISIBLE);



//                            getWindow().getDecorView().setSystemUiVisibility(
//                                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav
//                                            // bar
//                                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    class ImgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public ImgAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            Glide.with(mContext).load(s).into((ImageView) baseViewHolder.getView(R.id.rv_item_iv));
        }
    }
}
