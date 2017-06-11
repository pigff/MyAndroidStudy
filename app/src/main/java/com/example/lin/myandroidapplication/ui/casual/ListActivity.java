package com.example.lin.myandroidapplication.ui.casual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {

    private List<String> mProDatas;
    private Map<String, List<String>> mCities;
    private Map<String, List<String>> mProAreas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initData();
//        List<String> datas = new ArrayList<>();
//        datas.add("福建省");
//        datas.add("广东省");
        final TestAdapter proadApter = new TestAdapter(R.layout.recycler_area_item, mProDatas);
        final TestAdapter cityAdapter = new TestAdapter(R.layout.recycler_area_item, mCities.get(mProDatas.get(0)));
        final TestAdapter areaAdapter = new TestAdapter(R.layout.recycler_area_item);

        RecyclerView recyclerView01 = (RecyclerView) findViewById(R.id.rv_01);
        recyclerView01.setHasFixedSize(true);
        recyclerView01.setLayoutManager(new LinearLayoutManager(this));
        recyclerView01.setAdapter(proadApter);

        RecyclerView recyclerView02 = (RecyclerView) findViewById(R.id.rv_02);
        recyclerView02.setHasFixedSize(true);
        recyclerView02.setLayoutManager(new LinearLayoutManager(this));
        recyclerView02.setAdapter(cityAdapter);

        RecyclerView recyclerView03 = (RecyclerView) findViewById(R.id.rv_03);
        recyclerView03.setHasFixedSize(true);
        recyclerView03.setLayoutManager(new LinearLayoutManager(this));
        recyclerView03.setAdapter(areaAdapter);

        recyclerView01.addOnItemTouchListener(new OnItemChildClickListener() {

            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                boolean xx = proadApter.check(position);
                if (xx) {
                    cityAdapter.setNewData(mCities.get(((String) adapter.getItem(position))));
                    areaAdapter.setNewData(new ArrayList<String>());
                }
            }
        });

        recyclerView02.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                areaAdapter.setNewDatas(mProAreas.get(((String) adapter.getItem(position))));
            }
        });

        recyclerView03.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }


    private void initData() {
        mProDatas = new ArrayList<>();
        mProDatas.add("福建省");
        mProDatas.add("广东省");
        mCities = new HashMap<>();
        mProAreas = new HashMap<>();
        for (int i = 0; i < mProDatas.size(); i++) {
            List<String> partCities = new ArrayList<>();
            partCities.add("不限");
            if (i == 0) {
                partCities.add("福清市");
                partCities.add("厦门市");
                partCities.add("福州市");
            } else {
                partCities.add("深圳市");
                partCities.add("珠海市");
            }
            mCities.put(mProDatas.get(i), partCities);

        }
        for (int i = 0; i < mProDatas.size(); i++) {
            for (int j = 0; j < mCities.get(mProDatas.get(i)).size(); j++) {
                List<String> areas = new ArrayList<>();
                areas.add("不限");
                switch (mCities.get(mProDatas.get(i)).get(j)) {
                    case "福清市":
                        areas.add("福清01");
                        areas.add("福清02");
                        areas.add("福清03");
                        areas.add("福清04");
                        break;
                    case "厦门市":
                        areas.add("厦门01");
                        areas.add("厦门02");
                        areas.add("厦门03");
                        areas.add("厦门04");
                        areas.add("厦门05");
                        break;
                    case "福州市":
                        areas.add("福州01");
                        areas.add("福州02");
                        areas.add("福州03");
                        areas.add("福州04");
                        areas.add("福州05");
                        areas.add("福州06");
                        break;
                    case "深圳市":
                        areas.add("深圳01");
                        areas.add("深圳02");
                        areas.add("深圳03");
                        areas.add("深圳04");
                        areas.add("深圳05");
                        areas.add("深圳06");
                        break;
                    case "珠海市":
                        areas.add("珠海01");
                        areas.add("珠海02");
                        areas.add("珠海03");
                        areas.add("珠海04");
                        areas.add("珠海05");
                        break;
                    default:
                        areas.clear();
                        break;
                }
                mProAreas.put(mCities.get(mProDatas.get(i)).get(j), areas);
            }
        }

    }

    class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        private int currentPosition = 0;

        public TestAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        public TestAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_area_name, item)
                    .addOnClickListener(R.id.group_area);
        }

        public void setNewDatas(List<String> datas) {
            if (getData() == datas) {
                Log.d(TAG, "xixi重复了");
                return;
            }
            setNewData(datas);
//            currentPosition = position;
        }

        public boolean check(int position) {
            if (position == currentPosition) {
                return false;
            }
            currentPosition = position;
            return true;
        }
    }
}
