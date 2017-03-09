package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.ui.fragment.Blank1Fragment;

import java.util.ArrayList;
import java.util.List;

public class CoordinaLayout2Activity extends AppCompatActivity {

    public static final String DATA = "data";
    private String[] mTitles = {"第一个界面", "第二个界面", "第三个界面"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_coordina_layout2);
        setContentView(R.layout.activity_coordina_layout3);
        init();
    }

//    private void init() {
//        List<Blank1Fragment> fragments = new ArrayList<>();
//        for (int i = 0; i < mTitles.length; i++) {
//            Bundle bundle = new Bundle();
//            bundle.putString(DATA, mTitles[i]);
//            Blank1Fragment fragment = new Blank1Fragment();
//            fragment.setArguments(bundle);
//            fragments.add(fragment);
//        }
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.coordin2_tabs);
//        ViewPager pager = (ViewPager) findViewById(R.id.coordin_viewpager);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
//        pager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(pager);
//
//    }

    private void init() {
        List<Blank1Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(DATA, mTitles[i]);
            Blank1Fragment fragment = new Blank1Fragment();
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.coordin3_tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.coordin3_viewpager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.coordin3_toolbar3);
        toolbar.setTitle("秦时明月");
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Blank1Fragment> mFragments;

        public ViewPagerAdapter(FragmentManager fm, List<Blank1Fragment> fragments) {
            super(fm);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
