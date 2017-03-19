package com.example.lin.myandroidapplication.ui.aige;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.base.BaseRecyclerActivity;
import com.example.lin.myandroidapplication.data.ActivityData;

import java.util.ArrayList;
import java.util.List;

public class AigeViewListActivity extends BaseRecyclerActivity<ActivityData> {

    private List<ActivityData> mContents;


    @Override
    public void initListener() {
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityData item = (ActivityData) baseQuickAdapter.getItem(position);
                switch (view.getId()) {
                    case R.id.rv_card_title:
                        Intent intent = new Intent(AigeViewListActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        new AlertDialog.Builder(AigeViewListActivity.this)
                                .setTitle(item.getName())
                                .setView(getDialogView(item.getDescription()))
                                .show();
                        break;
                }
            }
        });
    }

    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("自定义View学习1/12", "圆形", AigeViewOneActivity.class));
        mContents.add(new ActivityData("自定义View学习1/6", "色彩偏移矩阵", AigeViewSecondActivity.class));
        mContents.add(new ActivityData("自定义View学习1/4", "色彩偏移矩阵", AigeThirdActivity.class));
        mContents.add(new ActivityData("自定义View学习1/3", "色彩偏移矩阵", AigeFourthActivity.class));
        mAdapter.setNewData(mContents);
    }

    @Override
    protected String getToolbarTitle() {
        return "爱哥自定义View学习";
    }

    private  View getDialogView(String des) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_text_item, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog);
        textView.setText(des);
        return view;
    }
}
