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
import com.example.lin.myandroidapplication.ui.aige.AigeViewListActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomizeViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ShowAdapter mAdapter;
    private List<ActivityData> mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_view);
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
                        Intent intent = new Intent(CustomizeViewActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        Toast.makeText(CustomizeViewActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_customize);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ShowAdapter(R.layout.rv_card_item, mContents);
    }

    private void initData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("爱哥的自定义", "爱哥的自定义文章学习", AigeViewListActivity.class));
    }
}
