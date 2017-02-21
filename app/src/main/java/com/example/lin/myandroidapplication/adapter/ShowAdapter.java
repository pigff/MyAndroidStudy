package com.example.lin.myandroidapplication.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.ActivityData;

import java.util.List;

/**
 * Created by lin on 2017/2/20.
 */
public class ShowAdapter extends BaseQuickAdapter<ActivityData, BaseViewHolder> {
    public ShowAdapter(int layoutResId, List<ActivityData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ActivityData content) {
        baseViewHolder.setText(R.id.rv_card_title, content.getName())
                    .addOnClickListener(R.id.rv_card)
                    .addOnClickListener(R.id.rv_card_des);
    }
}
