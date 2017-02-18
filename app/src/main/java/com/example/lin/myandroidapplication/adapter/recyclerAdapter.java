package com.example.lin.myandroidapplication.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.Category;
import com.example.lin.myandroidapplication.data.Multi;

import java.util.List;

/**
 * Created by lin on 2016/12/12.
 */
public class RecyclerAdapter extends BaseMultiItemQuickAdapter<Multi, BaseViewHolder> {

    private HoriListener mHoriListener;

    public RecyclerAdapter(List<Multi> data) {
        super(data);
        addItemType(Multi.HORIZION, R.layout.hori_rv_item);
        addItemType(Multi.IMAGE, R.layout.image_item);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Multi multi) {
        switch (baseViewHolder.getItemViewType()) {
            case Multi.HORIZION:
                RecyclerView recyclerView = baseViewHolder.getView(R.id.hori_rv);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                List<Category> categories = multi.getCategory();
                HoriRvAdapter adapter = new HoriRvAdapter(R.layout.category_item, categories);
                recyclerView.setAdapter(adapter);
                recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
                    @Override
                    public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        if (mHoriListener != null) {
                            mHoriListener.onItemClick(i, ((Category) baseQuickAdapter.getItem(i)));
                        }
                    }
                });
                break;
            case Multi.IMAGE:
                baseViewHolder.setImageResource(R.id.rv_img, multi.getImgSrc());
                break;
            default:
                break;
        }
    }

    class HoriRvAdapter extends BaseQuickAdapter<Category, BaseViewHolder> {
        public HoriRvAdapter(int layoutResId, List<Category> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, Category category) {
            baseViewHolder.setText(R.id.category_tv, category.getCategory())
                    .setImageResource(R.id.category_img, category.getImgSrc())
                    .addOnClickListener(R.id.category_group);
        }
    }

    public interface HoriListener {
        void onItemClick(int position, Category category);
    }

    public void setLisener(HoriListener lisener) {
        this.mHoriListener = lisener;
    }
}
