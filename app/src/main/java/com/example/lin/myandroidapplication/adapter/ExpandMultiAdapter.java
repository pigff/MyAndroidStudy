package com.example.lin.myandroidapplication.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.Leve0Item;
import com.example.lin.myandroidapplication.data.Level1Item;
import com.example.lin.myandroidapplication.data.Person;
import com.example.lin.myandroidapplication.data.Student;

import java.util.List;

/**
 * Created by lin on 2017/3/8.
 */

public class ExpandMultiAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;
    public static final int TYPE_STUDENT = 3;

    public ExpandMultiAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.recycler_expand_lv0_item);
        addItemType(TYPE_LEVEL_1, R.layout.recycler_expand_lv1_item);
        addItemType(TYPE_PERSON, R.layout.recycler_expand_lv2_item);
        addItemType(TYPE_STUDENT, R.layout.recycler_expand_lv2_item);
    }


    @Override
    protected void convert(final BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        switch (baseViewHolder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Leve0Item leve0Item = (Leve0Item) multiItemEntity;
                Glide.with(mContext)
                        .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=383177307,616280309&fm=23&gp=0.jpg")
                        .crossFade()
                        .into((ImageView) baseViewHolder.getView(R.id.iv_head_lv0));
                baseViewHolder.setText(R.id.title_lv0, leve0Item.getTitle())
                        .setImageResource(R.id.iv_lv0, leve0Item.isExpanded() ? R.mipmap.ic_arrow_b : R.mipmap.ic_arrow_r);
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = baseViewHolder.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (leve0Item.isExpanded()) {
                            collapse(pos);
                        } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                            expand(pos);
//                            }
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item level1Item = (Level1Item) multiItemEntity;
                Glide.with(mContext)
                        .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=383177307,616280309&fm=23&gp=0.jpg")
                        .crossFade()
                        .into((ImageView) baseViewHolder.getView(R.id.iv_head_lv1));
                baseViewHolder.setText(R.id.title_lv1, level1Item.getTitle())
                        .setImageResource(R.id.iv_lv1, level1Item.isExpanded() ? R.mipmap.ic_arrow_b : R.mipmap.ic_arrow_r);
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = baseViewHolder.getAdapterPosition();
                        Log.d(TAG, "Level 1 item pos: " + pos);
                        if (level1Item.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_PERSON:
                final Person person = (Person) multiItemEntity;
                Glide.with(mContext)
                        .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=383177307,616280309&fm=23&gp=0.jpg")
                        .crossFade()
                        .into((ImageView) baseViewHolder.getView(R.id.iv_head_lv2));
                baseViewHolder.setText(R.id.title_lv2, person.getTitle())
                        .setImageResource(R.id.iv_lv2, person.isExpanded() ? R.mipmap.ic_arrow_b : R.mipmap.ic_arrow_r);
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = baseViewHolder.getAdapterPosition();
                        Log.d(TAG, "Level 1 item pos: " + pos);
                        if (person.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });
                break;
            case TYPE_STUDENT:
                Student student = (Student) multiItemEntity;
                Glide.with(mContext)
                        .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=383177307,616280309&fm=23&gp=0.jpg")
                        .crossFade()
                        .into((ImageView) baseViewHolder.getView(R.id.iv_head_lv2));
                break;
            default:
                break;
        }
    }
}
