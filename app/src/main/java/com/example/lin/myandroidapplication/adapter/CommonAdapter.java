package com.example.lin.myandroidapplication.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/11/2.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    private List<T> mDatas;

    private int mLayoutRes;

    public CommonAdapter(List<T> datas, int layoutRes) {
        mDatas = datas;
        mLayoutRes = layoutRes;
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.bind(parent.getContext(), convertView, parent, mLayoutRes, position);
        bindView(holder, getItem(position));
        return holder.getItemView();
    }

    public abstract void bindView(ViewHolder holder, T obj);

    public void add(T data) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void add(int position, T data) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(position, data);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (mDatas != null) {
            mDatas.remove(position);
        }
        notifyDataSetChanged();
    }

    public void remove(T data) {
        if (mDatas != null) {
            mDatas.remove(data);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (mDatas != null) {
            mDatas.clear();
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder {

        private SparseArray<View> mViews;  //存储ListView的item中的View
        private View mItem;                //存放convertView
        private int position;              //游标
        private Context mContext;          //上下文

        private ViewHolder(ViewGroup parent, Context context, int layoutRes) {
            mViews = new SparseArray<>();
            this.mContext = context;
            View convert = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            convert.setTag(this);
            mItem = convert;
        }

        public static ViewHolder bind(Context context, View convertView, ViewGroup parent,
                                      int layoutRes, int position) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder(parent, context, layoutRes);
            } else {
                holder = (ViewHolder) convertView.getTag();
                holder.mItem = convertView;
            }
            holder.position = position;
            return holder;
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T getView(int id) {
            T t = (T) mViews.get(id);
            if (t == null) {
                t = (T) mItem.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }

        /**
         * 获取当前条目
         */
        public View getItemView() {
            return mItem;
        }

        /**
         * 获取条目文职
         * @return
         */
        public int getItemPosition() {
            return position;
        }

        public ViewHolder setText(int id, CharSequence text) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        public ViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }

        public ViewHolder setVisibility(int id, int visible) {
            getView(id).setVisibility(visible);
            return this;
        }

        public ViewHolder setTag(int id, Object obj) {
            getView(id).setTag(obj);
            return this;
        }
    }
}
