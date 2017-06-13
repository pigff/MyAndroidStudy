package com.example.lin.myandroidapplication.widget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by greedy on 2017/6/11.
 */

public class LinkedListView extends FrameLayout {

    private static final String TAG = "LinkedListView";
    private LinkedCallBack mCallBack;
    private ArrayList<AreaItem> mProDatas;
    private HashMap<String, List<AreaItem>> mCities;
    private HashMap<String, List<AreaItem>> mProAreas;

    public LinkedListView(@NonNull Context context) {
        this(context, null);
    }

    public LinkedListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinkedListView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initData();
        inflate(getContext(), R.layout.linkedlist, this);
        RecyclerView proRv = (RecyclerView) findViewById(R.id.rv_pro);
        proRv.setHasFixedSize(true);
        proRv.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView cityRv = (RecyclerView) findViewById(R.id.rv_city);
        cityRv.setHasFixedSize(true);
        cityRv.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView areaRv = (RecyclerView) findViewById(R.id.rv_area);
        areaRv.setHasFixedSize(true);
        areaRv.setLayoutManager(new LinearLayoutManager(getContext()));

        final LinkedListAdapter proadApter = new LinkedListAdapter(R.layout.recycler_area_item, mProDatas, 0);
        final LinkedListAdapter cityAdapter = new LinkedListAdapter(R.layout.recycler_area_item, mCities.get(mProDatas.get(0).getName()));
        final LinkedListAdapter areaAdapter = new LinkedListAdapter(R.layout.recycler_area_item);

        proRv.setAdapter(proadApter);
        cityRv.setAdapter(cityAdapter);
        areaRv.setAdapter(areaAdapter);

        proRv.addOnItemTouchListener(new OnItemChildClickListener() {

            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                boolean xx = proadApter.check(position);
                if (xx) {
                    cityAdapter.clearPosition();
                    areaAdapter.clearPosition();
                    cityAdapter.setNewData(mCities.get(((AreaItem) adapter.getItem(position)).getName()));
                    areaAdapter.setNewData(new ArrayList<AreaItem>());
                    proadApter.notifyItem(position);

                }
            }
        });

        cityRv.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String name = ((AreaItem) adapter.getItem(position)).getName();
                if (TextUtils.equals("不限", name) && mCallBack != null) {
                    mCallBack.clickCallBack(proadApter.getIndexData());
                }
                areaAdapter.clearPosition();
                areaAdapter.setNewDatas(mProAreas.get(name));
                cityAdapter.notifyItem(position);
            }
        });

        areaRv.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String name = ((AreaItem) adapter.getItem(position)).getName();
                areaAdapter.notifyItem(position);
                if (mCallBack != null && TextUtils.equals("不限", name)) {
                    mCallBack.clickCallBack(proadApter.getIndexData() + cityAdapter.getIndexData());
                } else if (mCallBack != null) {
                    mCallBack.clickCallBack(proadApter.getIndexData() + cityAdapter.getIndexData() + areaAdapter.getIndexData());
                }
            }
        });
    }

    public void setCallBack(LinkedCallBack callBack) {
        mCallBack = callBack;
    }

    private void initData() {
        mProDatas = new ArrayList<>();
        mProDatas.add(new AreaItem("福建省", true));
        mProDatas.add(new AreaItem("广东省", false));
        mCities = new HashMap<>();
        mProAreas = new HashMap<>();
        for (int i = 0; i < mProDatas.size(); i++) {
            List<AreaItem> partCities = new ArrayList<>();
            partCities.add(new AreaItem("不限", false));
            if (i == 0) {
                partCities.add(new AreaItem("福清市", false));
                partCities.add(new AreaItem("厦门市", false));
                partCities.add(new AreaItem("福州市", false));
            } else {
                partCities.add(new AreaItem("珠海市", false));
                partCities.add(new AreaItem("深圳市", false));
            }
            mCities.put(mProDatas.get(i).getName(), partCities);

        }
        for (int i = 0; i < mProDatas.size(); i++) {
            for (int j = 0; j < mCities.get(mProDatas.get(i).getName()).size(); j++) {
                List<AreaItem> areas = new ArrayList<>();
                areas.add(new AreaItem("不限", false));
                switch (mCities.get(mProDatas.get(i).getName()).get(j).getName()) {
                    case "福清市":
                        areas.add(new AreaItem("福清市01", false));
                        areas.add(new AreaItem("福清市02", false));
                        areas.add(new AreaItem("福清市03", false));
                        areas.add(new AreaItem("福清市04", false));
                        break;
                    case "厦门市":
                        areas.add(new AreaItem("厦门市01", false));
                        areas.add(new AreaItem("厦门市02", false));
                        areas.add(new AreaItem("厦门市03", false));
                        areas.add(new AreaItem("厦门市04", false));
                        areas.add(new AreaItem("厦门市05", false));
                        break;
                    case "福州市":
                        areas.add(new AreaItem("福州市01", false));
                        areas.add(new AreaItem("福州市02", false));
                        areas.add(new AreaItem("福州市03", false));
                        areas.add(new AreaItem("福州市04", false));
                        areas.add(new AreaItem("福州市05", false));
                        areas.add(new AreaItem("福州市06", false));
                        break;
                    case "深圳市":
                        areas.add(new AreaItem("深圳市01", false));
                        areas.add(new AreaItem("深圳市02", false));
                        areas.add(new AreaItem("深圳市03", false));
                        areas.add(new AreaItem("深圳市04", false));
                        areas.add(new AreaItem("深圳市05", false));
                        areas.add(new AreaItem("深圳市06", false));
                        break;
                    case "珠海市":
                        areas.add(new AreaItem("珠海市01", false));
                        areas.add(new AreaItem("珠海市02", false));
                        areas.add(new AreaItem("珠海市03", false));
                        areas.add(new AreaItem("珠海市04", false));
                        areas.add(new AreaItem("珠海市05", false));
                        break;
                    default:
                        areas.clear();
                        break;
                }
                mProAreas.put(mCities.get(mProDatas.get(i).getName()).get(j).getName(), areas);
            }
        }
    }

    class AreaItem {
        private String name;
        private boolean isChecked;

        public AreaItem(String name, boolean isChecked) {
            this.name = name;
            this.isChecked = isChecked;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AreaItem areaItem = (AreaItem) o;

            if (isChecked != areaItem.isChecked) return false;
            return name != null ? name.equals(areaItem.name) : areaItem.name == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (isChecked ? 1 : 0);
            return result;
        }
    }

    class LinkedListAdapter extends BaseQuickAdapter<AreaItem, BaseViewHolder> {

        private int currentPosition = -1;

        public LinkedListAdapter(int layoutResId, List<AreaItem> data) {
            super(layoutResId, data);
        }

        public LinkedListAdapter(int layoutResId, List<AreaItem> data, int currentPosition) {
            super(layoutResId, data);
            this.currentPosition = currentPosition;
        }

        public LinkedListAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, AreaItem item) {
            helper.setText(R.id.tv_area_name, item.getName())
                    .setVisible(R.id.view_area, item.isChecked)
                    .addOnClickListener(R.id.group_area);
        }

        public void setNewDatas(List<AreaItem> datas) {
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
//            currentPosition = position;
            return true;
        }

        public void notifyItem(int position) {
            if (position == currentPosition) {
                return;
            }
            if (currentPosition == -1) {
                currentPosition = position;
            }
            getData().get(currentPosition).setChecked(false);
            getData().get(position).setChecked(true);
            notifyDataSetChanged();
            currentPosition = position;
        }

        public void clearPosition() {
//            Log.d(TAG, "进来了");
            if (currentPosition != -1) {
//                Log.d(TAG, "okok");
                getData().get(currentPosition).setChecked(false);
//                notifyItemChanged(currentPosition);
                notifyDataSetChanged();
            }
            currentPosition = -1;
        }

        public String getIndexData() {
            if (currentPosition == -1) {
                return "";
            }
            return getData().get(currentPosition).getName();
        }
    }

    public interface LinkedCallBack {
        void clickCallBack(String text);
    }
}
