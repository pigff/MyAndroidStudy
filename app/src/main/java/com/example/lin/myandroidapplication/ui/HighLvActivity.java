package com.example.lin.myandroidapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.data.ActivityData;
import com.example.lin.myandroidapplication.ui.activity.AnimViewPagerActivity;
import com.example.lin.myandroidapplication.ui.activity.BehaviorStudyActivity;
import com.example.lin.myandroidapplication.ui.activity.CoordinaLayout2Activity;
import com.example.lin.myandroidapplication.ui.activity.CoordinaLayoutActivity;
import com.example.lin.myandroidapplication.ui.activity.DownloadActivity;
import com.example.lin.myandroidapplication.ui.activity.EventStudyActivity;
import com.example.lin.myandroidapplication.ui.activity.LoadingActivity;
import com.example.lin.myandroidapplication.ui.activity.LruCacheStudyActivity;
import com.example.lin.myandroidapplication.ui.activity.MPChartStudy2Activity;
import com.example.lin.myandroidapplication.ui.activity.MPchartActivity;
import com.example.lin.myandroidapplication.ui.activity.MultiRecyclerActivity;
import com.example.lin.myandroidapplication.ui.activity.RetrofitActivity;
import com.example.lin.myandroidapplication.ui.activity.RxJavaStudyActivity;
import com.example.lin.myandroidapplication.ui.activity.TabStudyActivity;

import java.util.ArrayList;
import java.util.List;

public class HighLvActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ShowAdapter mAdapter;
    private List<ActivityData> mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_lv);
        init();
    }

    private void init() {
        initData();

        initAdapter();

        initView();

        initListener();
    }

    private void initListener() {
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActivityData item = (ActivityData) baseQuickAdapter.getItem(i);
                switch (view.getId()) {
                    case R.id.rv_card:
                        Intent intent = new Intent(HighLvActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        Toast.makeText(HighLvActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.high_rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ShowAdapter(R.layout.rv_card_item, mContents);
    }

    private void initData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("Loading-anim", "......", LoadingActivity.class));
        mContents.add(new ActivityData("MultiRecycler", "......", MultiRecyclerActivity.class));
        mContents.add(new ActivityData("CoordinaLayout", "......", CoordinaLayoutActivity.class));
        mContents.add(new ActivityData("CoordinaLayout2", "......", CoordinaLayout2Activity.class));
        mContents.add(new ActivityData("LruCache", "......", LruCacheStudyActivity.class));
        mContents.add(new ActivityData("Retrofit", "......", RetrofitActivity.class));
        mContents.add(new ActivityData("EventBus", "......", EventStudyActivity.class));
        mContents.add(new ActivityData("ViewPager-Anim", "......", AnimViewPagerActivity.class));
        mContents.add(new ActivityData("Behavior", "......", BehaviorStudyActivity.class));
        mContents.add(new ActivityData("MPChart", "......", MPchartActivity.class));
        mContents.add(new ActivityData("MPChart2", "......", MPChartStudy2Activity.class));
        mContents.add(new ActivityData("Tab", "......", TabStudyActivity.class));
        mContents.add(new ActivityData("RxJava", "......", RxJavaStudyActivity.class));
        mContents.add(new ActivityData("Download", "......", DownloadActivity.class));
    }
}
