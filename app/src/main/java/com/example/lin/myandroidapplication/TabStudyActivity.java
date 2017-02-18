package com.example.lin.myandroidapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.example.lin.myandroidapplication.view.fragment.TabFragment;

import java.util.ArrayList;
import java.util.List;

public class TabStudyActivity extends AppCompatActivity {

    private List<TabFragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_study);
        initData();
        initView();
    }

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(TabFragment.newInstance("xixi", "hehe"));
        mFragments.add(TabFragment.newInstance("xixi2", "hehe"));
        mFragments.add(TabFragment.newInstance("xixi3", "hehe"));

    }

    private void initView() {
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.sliding_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_tab);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabStrip.setViewPager(viewPager);
    }

    class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            return "这 是 一 个 标 题 ";
        }
    }
}
