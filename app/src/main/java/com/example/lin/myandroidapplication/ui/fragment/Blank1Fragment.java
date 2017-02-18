package com.example.lin.myandroidapplication.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.ui.activity.CoordinaLayout2Activity;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Blank1Fragment extends Fragment {


    private RecyclerView mRecyclerView;
    private List<String> mStrings;
    private CoordinAdapter mAdapter;

    public Blank1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.blank_fm_rv);
        initData();
        initAdapter();
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new CoordinAdapter(R.layout.tv_item, mStrings);
    }

    private void initData() {
        Bundle bundle = getArguments();
        String title = bundle.getString(CoordinaLayout2Activity.DATA);
        mStrings = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mStrings.add(title + i + "个item");
        }
    }

    class CoordinAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public CoordinAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.tv, s);
        }
    }

}
