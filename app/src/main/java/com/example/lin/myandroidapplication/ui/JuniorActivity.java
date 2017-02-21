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
import com.example.lin.myandroidapplication.ui.activity.ButtonStudy;
import com.example.lin.myandroidapplication.ui.activity.EditTextStudy;
import com.example.lin.myandroidapplication.ui.activity.ImageViewStudy;
import com.example.lin.myandroidapplication.ui.activity.ListViewStudy;
import com.example.lin.myandroidapplication.ui.activity.ProgressStudy;
import com.example.lin.myandroidapplication.ui.activity.RadioAndCheckBtnStudy;
import com.example.lin.myandroidapplication.ui.activity.ScrollViewStudy;
import com.example.lin.myandroidapplication.ui.activity.SeekBarStudy;
import com.example.lin.myandroidapplication.ui.activity.ServiceStudy;
import com.example.lin.myandroidapplication.ui.activity.SpinnerStudy;
import com.example.lin.myandroidapplication.ui.activity.TextViewStudy;
import com.example.lin.myandroidapplication.ui.activity.ToggleStudy;
import com.example.lin.myandroidapplication.ui.activity.WebViewStudy;
import com.example.lin.myandroidapplication.ui.activity.WebViewStudy2;
import com.example.lin.myandroidapplication.ui.activity.WebViewStudy3;

import java.util.ArrayList;
import java.util.List;

public class JuniorActivity extends AppCompatActivity {

    private List<ActivityData> mContents;
    private ShowAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior);
        init();
    }

    private void init() {
        initData();

        initAdapter();

        initView();

        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActivityData item = (ActivityData) baseQuickAdapter.getItem(i);
                switch (view.getId()) {
                    case R.id.rv_card:
                        Intent intent = new Intent(JuniorActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        Toast.makeText(JuniorActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.junior_rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ShowAdapter(R.layout.rv_card_item, mContents);
    }

    private void initData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("TextView", "......", TextViewStudy.class));
        mContents.add(new ActivityData("Button", "......", ButtonStudy.class));
        mContents.add(new ActivityData("EditText", "......", EditTextStudy.class));
        mContents.add(new ActivityData("ImageView", "......", ImageViewStudy.class));
        mContents.add(new ActivityData("RadioButton and CheckBox", "......", RadioAndCheckBtnStudy.class));
        mContents.add(new ActivityData("ToggleButton and SwitchButton", "......", ToggleStudy.class));
        mContents.add(new ActivityData("SeekBar", "......", SeekBarStudy.class));
        mContents.add(new ActivityData("Progress", "......", ProgressStudy.class));
        mContents.add(new ActivityData("ScrollView", "......", ScrollViewStudy.class));
        mContents.add(new ActivityData("ListView", "......", ListViewStudy.class));
        mContents.add(new ActivityData("Spinner and AutoCompleteTextView", "......", SpinnerStudy.class));
        mContents.add(new ActivityData("WebView1", "......", WebViewStudy.class));
        mContents.add(new ActivityData("WebView2", "......", WebViewStudy2.class));
        mContents.add(new ActivityData("WebView3", "......", WebViewStudy3.class));
        mContents.add(new ActivityData("Service", "......", ServiceStudy.class));
    }

}
