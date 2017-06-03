package com.example.lin.myandroidapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.Constants;

public class ContainerActivity extends AppCompatActivity {

    public static final int BUTTON = 0;
    public static final int QI_ONE = 1;
    public static final int QI_EIGHT = 2;
    public static final int YANG_ONE = 3;
    public static final int YANG_SECOND = 4;
    public static final int YANG_FOUR = 5;
    public static final int YANG_FIFTH = 6;
    public static final int AIGE_THIRD = 7;
    public static final int AIGE_FOUR = 8;
    public static final int GCS_ONE = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int type = getIntent().getIntExtra(Constants.DATA, 0);
        switch (type) {
            case BUTTON:
                setContentView(R.layout.activity_btn_layout);
                break;
            case QI_ONE:
                setContentView(R.layout.activity_qi_view_first);
                break;
            case QI_EIGHT:
                setContentView(R.layout.activity_qi_view_eight);
                break;
            case YANG_ONE:
                setContentView(R.layout.activity_yang_view_first);
                break;
            case YANG_SECOND:
                setContentView(R.layout.activity_yang_view_second);
                break;
            case YANG_FOUR:
                setContentView(R.layout.activity_yang_four);
                break;
            case YANG_FIFTH:
                setContentView(R.layout.activity_yang_view_fifth);
                break;
            case AIGE_THIRD:
                setContentView(R.layout.activity_aige_third);
                break;
            case AIGE_FOUR:
                setContentView(R.layout.activity_aige_fourth);
                break;
            case GCS_ONE:
                setContentView(R.layout.activity_gcs_one);
        }
    }
}
