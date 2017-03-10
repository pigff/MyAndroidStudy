package com.example.lin.myandroidapplication.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.SignDayListBean;

import java.util.Calendar;
import java.util.List;

import static com.example.lin.myandroidapplication.adapter.SignInAdapter.GOLD_DAY;

/**
 * Created by lin on 2017/3/10.
 */

public class SignInQuickAdapter extends BaseQuickAdapter<SignDayListBean, BaseViewHolder> {

    private int today;
    public SignInQuickAdapter(int layoutResId, List<SignDayListBean> data) {
        super(layoutResId, data);
        //获取当前时间
        today = getCurrentDate();
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, SignDayListBean signDayListBean) {
        int position = baseViewHolder.getAdapterPosition();
        if (signDayListBean != null) {
            if (signDayListBean.isSigned()) {
                baseViewHolder.setImageResource(R.id.iv_item_sign_in, R.drawable.sign_in_done_2);
            } else {

                if (position + 1 < today) {
                    baseViewHolder.setImageResource(R.id.iv_item_sign_in, R.drawable.sign_in_undo);
                } else if (0 <= position & position < GOLD_DAY) {
                    baseViewHolder.setImageResource(R.id.iv_item_sign_in, R.drawable.sign_in_nor_gold);
                } else {
//                if (signDayListBean.getPrizeList() != null) {
//                    if (signDayListBean.getPrizeList().size() > 0) {
//                        bindImg(holder.img, ServiceUrl.img_service + signDayListBean.getPrizeList().get(0).getPrize().getImageUrl());
//                        //todo 奖品数量为0，默认图片
//                    }
//                } else {
//                    //没有奖品，默认图片
                    baseViewHolder.setImageResource(R.id.iv_item_sign_in, R.drawable.sign_in_nor_gold);
//                }
                }
            }
            baseViewHolder.setText(R.id.tv_item_sign_in_value, String.valueOf(position + 1));
        }
    }


    //获取当前时间
    private int getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }
}
