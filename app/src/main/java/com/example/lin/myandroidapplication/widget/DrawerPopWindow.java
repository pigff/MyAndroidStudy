package com.example.lin.myandroidapplication.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;

import java.util.List;


/**
 * Created by lin on 2016/8/10.
 */
public class DrawerPopWindow extends PopupWindow {

    private View contentView;
    private TextView mTitleTv;
    private RecyclerView mRecyclerView;
    private Button mCancelBtn;
    private Button mConfirmBtn;


    public DrawerPopWindow(final Activity context, String title, List<String> categoryList) {
        this(context);
        mTitleTv.setText(title);
        PopGrid3Adapter adapter = new PopGrid3Adapter(R.layout.right_pop_item, categoryList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        mRecyclerView.setAdapter(adapter);
        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(context, "baseQuickAdapter.getItem(i):" + baseQuickAdapter.getItem(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public DrawerPopWindow(final Activity context, List<String> categoryList) {
        this(context);
        mTitleTv.setText("类别");
        PopGrid2Adapter adapter = new PopGrid2Adapter(R.layout.right_pop_item, categoryList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        mRecyclerView.setAdapter(adapter);
        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(context, "baseQuickAdapter.getItem(i):" + baseQuickAdapter.getItem(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public DrawerPopWindow(Activity context) {
        Point x = new Point();
        context.getWindowManager().getDefaultDisplay().getSize(x);
        int w = x.x;
        setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        setWidth(w - w / 5);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        ColorDrawable dw = new ColorDrawable(00000000);
        setBackgroundDrawable(dw);
        setAnimationStyle(R.style.AnimationPreview);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.right_pop_window, null);
        mTitleTv = (TextView) contentView.findViewById(R.id.right_pop_title);
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.right_pop_rv);
        mCancelBtn = (Button) contentView.findViewById(R.id.right_pop_cancel_btn);
        mConfirmBtn = (Button) contentView.findViewById(R.id.right_pop_confirm_btn);
        setContentView(contentView);
    }


    public void showPoppupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAtLocation(parent, Gravity.RIGHT, 0, 0);
        } else {
            this.dismiss();
        }
    }

    class PopGrid3Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public PopGrid3Adapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.right_pop_item_tv, s)
                    .addOnClickListener(R.id.right_pop_item_tv);
        }
    }

    class PopGrid2Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public PopGrid2Adapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.right_pop_item_tv, s)
                    .addOnClickListener(R.id.right_pop_item_tv);
        }
    }

}
