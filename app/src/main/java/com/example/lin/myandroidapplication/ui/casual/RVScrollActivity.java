package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RVScrollActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvscroll);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_scroll_rv);
        List<String> imgUrls = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            imgUrls.add("http://img2.imgtn.bdimg.com/it/u=4207984293,3460265301&fm=23&gp=0.jpg");
        }
        ImgAdapter adapter = new ImgAdapter(R.layout.rv_img_item, imgUrls);
        mRecyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("RVScrollActivity", "newState:" + newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Glide.with(RVScrollActivity.this).pauseRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        Glide.with(RVScrollActivity.this).pauseRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Glide.with(RVScrollActivity.this).resumeRequests();
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.fab_rv);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RVScrollActivity.this, "tap", Toast.LENGTH_SHORT).show();
                mRecyclerView.getLayoutManager().scrollToPosition(0);
            }
        });
    }

    class ImgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public ImgAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            long time = System.currentTimeMillis();
            Glide.with(mContext).load(s).placeholder(R.mipmap.ic_launcher).fitCenter().
                    into((ImageView) baseViewHolder.getView(R.id.rv_item_iv));
        }
    }
}
