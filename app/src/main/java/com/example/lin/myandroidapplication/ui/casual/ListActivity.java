package com.example.lin.myandroidapplication.ui.casual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        List<String> datas = new ArrayList<>();
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        datas.add("福清市");
        RecyclerView recyclerView01 = (RecyclerView) findViewById(R.id.rv_01);
        recyclerView01.setHasFixedSize(true);
        recyclerView01.setLayoutManager(new LinearLayoutManager(this));
        recyclerView01.setAdapter(new TestAdapter(R.layout.recycler_test_item, datas));
        RecyclerView recyclerView02 = (RecyclerView) findViewById(R.id.rv_02);
        recyclerView02.setHasFixedSize(true);
        recyclerView02.setLayoutManager(new LinearLayoutManager(this));
        recyclerView02.setAdapter(new TestAdapter(R.layout.recycler_test_item, datas));
        RecyclerView recyclerView03 = (RecyclerView) findViewById(R.id.rv_03);
        recyclerView03.setHasFixedSize(true);
        recyclerView03.setLayoutManager(new LinearLayoutManager(this));
        recyclerView03.setAdapter(new TestAdapter(R.layout.recycler_test_item, datas));
    }

    class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public TestAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_test_item, item);
        }
    }
}
