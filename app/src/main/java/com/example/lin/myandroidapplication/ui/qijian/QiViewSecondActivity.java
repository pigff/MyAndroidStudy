package com.example.lin.myandroidapplication.ui.qijian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.qijian.PaintAdvancedView;

public class QiViewSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_view_second);
        FrameLayout layout = (FrameLayout) findViewById(R.id.frame_layout_qi);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        PaintView paintView = new PaintView(this);
//        paintView.setLayoutParams(layoutParams);
//        layout.addView(paintView);
//        PathView pathView = new PathView(this);
//        pathView.setLayoutParams(layoutParams);
//        layout.addView(pathView);
//        PaintTextView paintTextView = new PaintTextView(this);
//        paintTextView.setLayoutParams(layoutParams);
//        layout.addView(paintTextView);
//        RegionView regionView = new RegionView(this);
//        regionView.setLayoutParams(layoutParams);
//        layout.addView(regionView);
//        CanvasView canvasView = new CanvasView(this);
//        canvasView.setLayoutParams(layoutParams);
//        layout.addView(canvasView);
        PaintAdvancedView advancedView = new PaintAdvancedView(this);
        advancedView.setLayoutParams(layoutParams);
        layout.addView(advancedView);
    }
}
