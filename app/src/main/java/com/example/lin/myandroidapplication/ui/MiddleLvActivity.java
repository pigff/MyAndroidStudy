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
import com.example.lin.myandroidapplication.ui.activity.AnimStudyActivity;
import com.example.lin.myandroidapplication.ui.activity.DialogStudy;
import com.example.lin.myandroidapplication.ui.activity.DrawableActivity;
import com.example.lin.myandroidapplication.ui.activity.ExpandActivity;
import com.example.lin.myandroidapplication.ui.activity.LoadTestActivity;
import com.example.lin.myandroidapplication.ui.activity.PopRightActivity;
import com.example.lin.myandroidapplication.ui.activity.PopWindowStudy;
import com.example.lin.myandroidapplication.ui.activity.PropertyAnim2Activity;
import com.example.lin.myandroidapplication.ui.activity.PropertyAnimStudyActivity;
import com.example.lin.myandroidapplication.ui.activity.RVScrollActivity;
import com.example.lin.myandroidapplication.ui.activity.ToolbarActivity;
import com.example.lin.myandroidapplication.ui.activity.TurnSaveStudy;
import com.example.lin.myandroidapplication.ui.activity.VFStudyActivity;

import java.util.ArrayList;
import java.util.List;

public class MiddleLvActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ShowAdapter mAdapter;
    private List<ActivityData> mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_lv);
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
                        Intent intent = new Intent(MiddleLvActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        Toast.makeText(MiddleLvActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
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
        mContents.add(new ActivityData("Dialog", "......", DialogStudy.class));
        mContents.add(new ActivityData("PopupWindow", "......", PopWindowStudy.class));
        mContents.add(new ActivityData("Turn-Save", "屏幕翻转保存数据", TurnSaveStudy.class));
        mContents.add(new ActivityData("Drawable", "......", DrawableActivity.class));
        mContents.add(new ActivityData("Toolbar", "......", ToolbarActivity.class));
        mContents.add(new ActivityData("ExpandListView", "......", ExpandActivity.class));
        mContents.add(new ActivityData("PopRight", "从右侧弹出的PopupWindow,仿淘宝筛选", PopRightActivity.class));
        mContents.add(new ActivityData("Anim", "补间动画学习", AnimStudyActivity.class));
        mContents.add(new ActivityData("PropertyAnim", "属性动画学习", PropertyAnimStudyActivity.class));
        mContents.add(new ActivityData("PropertyAnim2", "属性动画学习", PropertyAnim2Activity.class));
        mContents.add(new ActivityData("ViewFlipper", "ViewFlipper使用学习", VFStudyActivity.class));
        mContents.add(new ActivityData("RvScroll-Glide", "RecyclerView滑动时停止加载图片", RVScrollActivity.class));
        mContents.add(new ActivityData("Load-Rv", "进入界面时的加载练习", LoadTestActivity.class));
    }
}
