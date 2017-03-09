package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ExpandMultiAdapter;
import com.example.lin.myandroidapplication.data.Leve0Item;
import com.example.lin.myandroidapplication.data.Level1Item;
import com.example.lin.myandroidapplication.data.Person;
import com.example.lin.myandroidapplication.data.Student;
import com.example.lin.myandroidapplication.ui.base.BaseFunActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExpandRvActivity extends BaseFunActivity {

    private List<MultiItemEntity> mMultiItemEntities;
    private ExpandMultiAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_rv);
        init();
    }

    private void init() {
        initData();

        initAdapter();

        initView();
    }

    private void initAdapter() {
        mAdapter = new ExpandMultiAdapter(mMultiItemEntities);
    }

    @Override
    public void initData() {
        mMultiItemEntities = generateData();
    }

    @Override
    public void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_expand);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Leve0Item lv0 = new Leve0Item("第一栏 " + i + "标题");
            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item("level" + i + "item: " + j);
                for (int k = 0; k < personCount; k++) {
                    Person subItem = new Person("小王" + k);
                    for (int g = 0; g < personCount; g++) {
                        subItem.addSubItem(new Student("小学生", 11));
                    }
                    lv1.addSubItem(subItem);
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }
}
