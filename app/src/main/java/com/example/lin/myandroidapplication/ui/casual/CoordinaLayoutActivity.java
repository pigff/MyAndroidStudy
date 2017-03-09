package com.example.lin.myandroidapplication.ui.casual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CoordinaLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CoordinAdapter mAdapter;
    private List<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_coordina_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.coordin_rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.coodin_toolbar);
        toolbar.setTitle("toolbar");
        initData();
        initAdapter();
        initView();
    }

    private void initView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new CoordinAdapter(R.layout.tv_item, mStrings);
    }

    private void initData() {
        mStrings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mStrings.add("第" + i + "个item");
        }
    }

    class CoordinAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public CoordinAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.tv, s);
        }
    }
}
