package com.example.lin.myandroidapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.SignDayListBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2016-06-03.
 */
public class SignInAdapter extends RecyclerView.Adapter<SignInAdapter.MyViewHolder> {

    public static final int GOLD_DAY = 3;

    private Context context;
    private int today;
    private List<SignDayListBean> signDayListBeenList = new ArrayList<>();

    public SignInAdapter(Context context) {
        this.context = context;
        //获取当前时间
        today = getCurrentDate();
    }

    public void setData(List<SignDayListBean> signDayListBeenList) {
        this.signDayListBeenList.clear();
        if (signDayListBeenList != null) {
            this.signDayListBeenList.addAll(signDayListBeenList);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sign_in2, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SignDayListBean signDayListBean = signDayListBeenList.get(position);
        if (signDayListBean.isSigned()) {
            holder.img.setBackgroundResource(R.drawable.sign_in_done_2);
        } else {
            if (position + 1 < today) {
                holder.img.setBackgroundResource(R.drawable.sign_in_undo);
            } else if (0 <= position & position < GOLD_DAY) {
                holder.img.setBackgroundResource(R.drawable.sign_in_nor_gold);
            } else {
//                if (signDayListBean.getPrizeList() != null) {
//                    if (signDayListBean.getPrizeList().size() > 0) {
//                        bindImg(holder.img, ServiceUrl.img_service + signDayListBean.getPrizeList().get(0).getPrize().getImageUrl());
//                        //todo 奖品数量为0，默认图片
//                    }
//                } else {
//                    //没有奖品，默认图片
                holder.img.setBackgroundResource(R.drawable.sign_in_nor_gold);
//                }
            }
        }

        holder.tvValue.setText("" + (position + 1));

        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return signDayListBeenList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvValue;
        private int position;

        public MyViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.iv_item_sign_in);
            tvValue = (TextView) view.findViewById(R.id.tv_item_sign_in_value);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(position, signDayListBeenList.get(position));
                    }
                }
            });
        }
    }


    public void setSignIn(int position, RecyclerView rvSign) {
        SignInAdapter.MyViewHolder viewHolder = (SignInAdapter.MyViewHolder) rvSign.findViewHolderForAdapterPosition(position);
        viewHolder.img.setBackgroundResource(R.drawable.sign_in_done_2);
    }

    public void setReSign(int position, RecyclerView rvSign) {
        SignInAdapter.MyViewHolder viewHolder = (SignInAdapter.MyViewHolder) rvSign.findViewHolderForAdapterPosition(position);
        viewHolder.img.setBackgroundResource(R.drawable.sign_in_done_2);
    }


    //获取当前时间
    private int getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    private ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void onItemClick(int position, SignDayListBean signDayListBean);
    }

    public void addItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
