package com.example.lin.myandroidapplication.ui.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.VpBean;
import com.example.lin.myandroidapplication.util.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class AnimViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<VpBean> mBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_view_pager);
        init();
    }

    private void init() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int width = point.x / 3;
        int height = point.y / 7;
        mBeen = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mBeen.add(new VpBean(R.drawable.image, "嘻嘻" + i));
        }
        mViewPager = (ViewPager) findViewById(R.id.anim_vp);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mViewPager.setLayoutParams(params);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ry_container);
//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return mViewPager.dispatchTouchEvent(event);
//            }
//        });

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(20);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        MyPagerAdapter adapter = new MyPagerAdapter();
        mViewPager.setAdapter(adapter);
    }

    class MyPagerAdapter extends PagerAdapter {


        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = getLayoutInflater().inflate(R.layout.img_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.viewpager_img);
            TextView textView = (TextView) view.findViewById(R.id.viewpager_tv);
            textView.setText(mBeen.get(position).getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AnimViewPagerActivity.this, "xixi" + position, Toast.LENGTH_SHORT).show();
                }
            });
            imageView.setImageResource(mBeen.get(position).getImgSrc());
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return mBeen.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
