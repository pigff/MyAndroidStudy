package com.example.lin.myandroidapplication.ui;

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

public class MainActivity extends BaseRecyclerActivity<ActivityData> {

    private List<ActivityData> mContents;


    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("学习code-pig系列", "code-pig Android入门系列的学习", CodePigActivity.class));
        mContents.add(new ActivityData("自己随意的学习", "网上的一些相关文章的学习", CasualActivity.class));
        mContents.add(new ActivityData("自定义View相关的学习", "自定义View那些事", CustomizeViewActivity.class));
        mContents.add(new ActivityData("Test", "......", TestActivity.class));
        mAdapter.setNewData(mContents);
    }

    @Override
    public void initListener() {
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityData item = (ActivityData) baseQuickAdapter.getItem(position);
                switch (view.getId()) {
                    case R.id.rv_card_title:
                        Intent intent = new Intent(MainActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle(item.getName())
                                .setView(getDialogView(item.getDescription()))
                                .show();
                        break;
                }
            }
        });
    }

    @Override
    protected String getToolbarTitle() {
        return "我的首页列表";
    }

    private  View getDialogView(String des) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_text_item, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog);
        textView.setText(des);
        return view;
    }

}
