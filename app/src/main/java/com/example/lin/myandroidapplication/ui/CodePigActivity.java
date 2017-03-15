package com.example.lin.myandroidapplication.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.base.BaseRecyclerActivity;
import com.example.lin.myandroidapplication.data.ActivityData;
import com.example.lin.myandroidapplication.ui.casual.ToggleStudy;
import com.example.lin.myandroidapplication.ui.pig.AnimStudyActivity;
import com.example.lin.myandroidapplication.ui.pig.ButtonStudy;
import com.example.lin.myandroidapplication.ui.pig.DialogStudy;
import com.example.lin.myandroidapplication.ui.pig.DrawableActivity;
import com.example.lin.myandroidapplication.ui.pig.EditTextStudy;
import com.example.lin.myandroidapplication.ui.pig.ExpandActivity;
import com.example.lin.myandroidapplication.ui.pig.ImageViewStudy;
import com.example.lin.myandroidapplication.ui.pig.ListViewStudy;
import com.example.lin.myandroidapplication.ui.pig.PopWindowStudy;
import com.example.lin.myandroidapplication.ui.pig.ProgressStudy;
import com.example.lin.myandroidapplication.ui.pig.PropertyAnim2Activity;
import com.example.lin.myandroidapplication.ui.pig.PropertyAnimStudyActivity;
import com.example.lin.myandroidapplication.ui.pig.RadioAndCheckBtnStudy;
import com.example.lin.myandroidapplication.ui.pig.ScrollViewStudy;
import com.example.lin.myandroidapplication.ui.pig.SeekBarStudy;
import com.example.lin.myandroidapplication.ui.pig.ServiceStudy;
import com.example.lin.myandroidapplication.ui.pig.SpinnerStudy;
import com.example.lin.myandroidapplication.ui.pig.TextViewStudy;
import com.example.lin.myandroidapplication.ui.pig.WebViewStudy;
import com.example.lin.myandroidapplication.ui.pig.WebViewStudy2;
import com.example.lin.myandroidapplication.ui.pig.WebViewStudy3;

import java.util.ArrayList;
import java.util.List;

public class CodePigActivity extends BaseRecyclerActivity<ActivityData> {

    private List<ActivityData> mContents;


    @Override
    public void initListener() {
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityData item = (ActivityData) baseQuickAdapter.getItem(position);
                switch (view.getId()) {
                    case R.id.rv_card_title:
                        Intent intent = new Intent(CodePigActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        Toast.makeText(CodePigActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("TextView", "......", TextViewStudy.class));
        mContents.add(new ActivityData("Button", "......", ButtonStudy.class));
        mContents.add(new ActivityData("EditText", "......", EditTextStudy.class));
        mContents.add(new ActivityData("ImageView", "......", ImageViewStudy.class));
        mContents.add(new ActivityData("RadioButton and CheckBox", "......", RadioAndCheckBtnStudy.class));
        mContents.add(new ActivityData("ToggleButton and SwitchButton", "......", ToggleStudy.class));
        mContents.add(new ActivityData("Progress", "......", ProgressStudy.class));
        mContents.add(new ActivityData("SeekBar", "......", SeekBarStudy.class));
        mContents.add(new ActivityData("ScrollView", "......", ScrollViewStudy.class));
        mContents.add(new ActivityData("ListView", "......", ListViewStudy.class));
        mContents.add(new ActivityData("Dialog", "......", DialogStudy.class));
        mContents.add(new ActivityData("PopupWindow", "......", PopWindowStudy.class));
        mContents.add(new ActivityData("Spinner and AutoCompleteTextView", "......", SpinnerStudy.class));
        mContents.add(new ActivityData("ExpandListView", "......", ExpandActivity.class));
        mContents.add(new ActivityData("Service", "......", ServiceStudy.class));
        mContents.add(new ActivityData("WebView1", "......", WebViewStudy.class));
        mContents.add(new ActivityData("WebView2", "......", WebViewStudy2.class));
        mContents.add(new ActivityData("WebView3", "......", WebViewStudy3.class));
        mContents.add(new ActivityData("Drawable", "......", DrawableActivity.class));
        mContents.add(new ActivityData("Anim", "补间动画学习", AnimStudyActivity.class));
        mContents.add(new ActivityData("PropertyAnim", "属性动画学习", PropertyAnimStudyActivity.class));
        mContents.add(new ActivityData("PropertyAnim2", "属性动画学习", PropertyAnim2Activity.class));
        mAdapter.setNewData(mContents);
    }

    @Override
    protected String getToolbarTitle() {
        return "随意学习";
    }

}
