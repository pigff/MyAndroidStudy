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
import com.example.lin.myandroidapplication.ui.casual.AnimViewPagerActivity;
import com.example.lin.myandroidapplication.ui.casual.BehaviorStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.CheckinActivity;
import com.example.lin.myandroidapplication.ui.casual.CoordinaLayout2Activity;
import com.example.lin.myandroidapplication.ui.casual.CoordinaLayoutActivity;
import com.example.lin.myandroidapplication.ui.casual.DownloadActivity;
import com.example.lin.myandroidapplication.ui.casual.EventStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.ExpandRvActivity;
import com.example.lin.myandroidapplication.ui.casual.LoadTestActivity;
import com.example.lin.myandroidapplication.ui.casual.LoadingActivity;
import com.example.lin.myandroidapplication.ui.casual.LruCacheStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.MPChartStudy2Activity;
import com.example.lin.myandroidapplication.ui.casual.MPchartActivity;
import com.example.lin.myandroidapplication.ui.casual.MdActivity;
import com.example.lin.myandroidapplication.ui.casual.MultiRecyclerActivity;
import com.example.lin.myandroidapplication.ui.casual.PopRightActivity;
import com.example.lin.myandroidapplication.ui.casual.RVScrollActivity;
import com.example.lin.myandroidapplication.ui.casual.RetrofitActivity;
import com.example.lin.myandroidapplication.ui.casual.RxJavaStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.TabStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.ToolbarActivity;
import com.example.lin.myandroidapplication.ui.casual.TurnSaveStudy;
import com.example.lin.myandroidapplication.ui.casual.VFStudyActivity;

import java.util.ArrayList;
import java.util.List;

public class CasualActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ShowAdapter mAdapter;
    private List<ActivityData> mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casual);
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
                        Intent intent = new Intent(CasualActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        Toast.makeText(CasualActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.middle_rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ShowAdapter(R.layout.rv_card_item, mContents);
    }

    private void initData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("Turn-Save", "屏幕翻转保存数据", TurnSaveStudy.class));
        mContents.add(new ActivityData("Toolbar", "......", ToolbarActivity.class));
        mContents.add(new ActivityData("PopRight", "从右侧弹出的PopupWindow,仿淘宝筛选", PopRightActivity.class));
        mContents.add(new ActivityData("ViewFlipper", "ViewFlipper使用学习", VFStudyActivity.class));
        mContents.add(new ActivityData("RvScroll-Glide", "RecyclerView滑动时停止加载图片", RVScrollActivity.class));
        mContents.add(new ActivityData("Rv-Expand", "可以展开的RecyclerView联系", ExpandRvActivity.class));
        mContents.add(new ActivityData("Load-Rv", "进入界面时的加载练习", LoadTestActivity.class));
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
        mContents.add(new ActivityData("Check In", "......", CheckinActivity.class));
        mContents.add(new ActivityData("Test MD", "......", MdActivity.class));
    }
}
