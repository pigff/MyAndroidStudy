package com.example.lin.myandroidapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.RecyclerAdapter;
import com.example.lin.myandroidapplication.data.Category;
import com.example.lin.myandroidapplication.data.Multi;

import java.util.ArrayList;
import java.util.List;

public class MultiRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Multi> mMultis;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_recycler);
        mRecyclerView = (RecyclerView) findViewById(R.id.multi_rv);
        initData();
        initAdapter();
        initView();
    }

    private void initView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mAdapter);

    }

    private void initAdapter() {
        mAdapter = new RecyclerAdapter(mMultis);
        mAdapter.setLisener(new RecyclerAdapter.HoriListener() {
            @Override
            public void onItemClick(int position, Category category) {
                Toast.makeText(MultiRecyclerActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                Log.d("MultiRecyclerActivity", category.toString());
            }
        });
    }

    private void initData() {
        mMultis = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        Category category = new Category(R.mipmap.ic_launcher, "第一个");
        Category category2 = new Category(R.mipmap.ic_launcher, "第二个");
        Category category3 = new Category(R.mipmap.ic_launcher, "第三个");
        Category category4 = new Category(R.mipmap.ic_launcher, "第四个");
        Category category5 = new Category(R.mipmap.ic_launcher, "第五个");
        Category category6 = new Category(R.mipmap.ic_launcher, "第六个");
        Category category7 = new Category(R.mipmap.ic_launcher, "第七个");
        categories.add(category);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);
        Multi multi = new Multi(Multi.IMAGE, R.drawable.image);
        Multi multi4 = new Multi(Multi.IMAGE, R.drawable.image);
        Multi multi5 = new Multi(Multi.IMAGE, R.drawable.image);
        Multi multi6 = new Multi(Multi.IMAGE, R.drawable.image);
        Multi multi7 = new Multi(Multi.IMAGE, R.drawable.image);
        Multi multi2 = new Multi(Multi.HORIZION, categories);
        Multi multi3 = new Multi(Multi.HORIZION, categories);
        mMultis.add(multi);
        mMultis.add(multi2);
        mMultis.add(multi3);
        mMultis.add(multi4);
        mMultis.add(multi5);
        mMultis.add(multi6);
        mMultis.add(multi7);
    }
}
