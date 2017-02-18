package com.example.lin.myandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.charts.ScatterChart;

public class MPchartActivity extends AppCompatActivity {

    private BarChart mBarChart;
    private BubbleChart mBubbleChart;
    private CandleStickChart mCandleStickChart;
    private CombinedChart mCombinedChart;
    private HorizontalBarChart mHorizontalBarChart;
    private LineChart mLineChart;
    private PieChart mPieChart;
    private RadarChart mRadarChart;
    private ScatterChart mScatterChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpchart);
        initView();
    }

    private void initView() {
        mBarChart = (BarChart) findViewById(R.id.barchart);
        mBubbleChart = (BubbleChart) findViewById(R.id.bubblechart);
        mCandleStickChart = (CandleStickChart) findViewById(R.id.candlestickchart);
        mCombinedChart = (CombinedChart) findViewById(R.id.combinedchart);
        mHorizontalBarChart = (HorizontalBarChart) findViewById(R.id.horizontalbarchart);
        mLineChart = (LineChart) findViewById(R.id.linechart);
        mPieChart = (PieChart) findViewById(R.id.piechart);
        mRadarChart = (RadarChart) findViewById(R.id.radarchart);
        mScatterChart = (ScatterChart) findViewById(R.id.scatterchart);
    }
}
