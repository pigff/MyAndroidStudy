package com.example.lin.myandroidapplication.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.ui.activity.TestEventActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BlankFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView mTestTv;


    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        mTestTv = (TextView) view.findViewById(R.id.test_event_tv);
        mTestTv.setText(mParam1);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe
    public void onEventMainThread(String content) {
        mTestTv.setText(content);
    }

    @Subscribe
    public void onEventMainThread(TestEventActivity.TestBean testBean) {
        if (TextUtils.equals(mParam1, "第一个"))
            mTestTv.setText(testBean.getName());
    }

    @Subscribe
    public void onEventMainThread(Integer count) {
        if (TextUtils.equals(mParam1, "第一个"))
            mTestTv.setText(String.valueOf(count));
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
