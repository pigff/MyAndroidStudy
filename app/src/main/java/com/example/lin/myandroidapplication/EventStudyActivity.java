package com.example.lin.myandroidapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.view.fragment.BlankFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class EventStudyActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private List<BlankFragment> mFragments;
    private Button mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_study);
        EventBus.getDefault().register(this);
        init();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(BlankFragment.newInstance("第一个", "xixi"));
        mFragments.add(BlankFragment.newInstance("第二个", "xixi"));
        mFragments.add(BlankFragment.newInstance("第三个", "xixi"));

        mButton1 = (Button) findViewById(R.id.event_btn_01);
        mButton2 = (Button) findViewById(R.id.event_btn_02);
        mButton3 = (Button) findViewById(R.id.event_btn_03);
        mButton4 = (Button) findViewById(R.id.event_btn_04);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.event_viewpager);
        EventAdapter adapter = new EventAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
    }

    @Subscribe
    public void onEventMainThread(int content){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.event_btn_01:
                EventBus.getDefault().post("第一个fragment变化");
                break;
            case R.id.event_btn_02:
                EventBus.getDefault().post("第二个fragment变化");
                break;
            case R.id.event_btn_03:
                EventBus.getDefault().post("第三个fragment变化");
                break;
            case R.id.event_btn_04:
                Intent intent = new Intent(this, TestEventActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    class EventAdapter extends FragmentPagerAdapter {

        public EventAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
