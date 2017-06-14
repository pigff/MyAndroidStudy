package com.example.lin.myandroidapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.base.BaseRecyclerActivity;
import com.example.lin.myandroidapplication.data.ActivityData;
import com.example.lin.myandroidapplication.ui.casual.AnimViewPagerActivity;
import com.example.lin.myandroidapplication.ui.casual.BehaviorStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.CheckinActivity;
import com.example.lin.myandroidapplication.ui.casual.CoordinaLayout2Activity;
import com.example.lin.myandroidapplication.ui.casual.CoordinaLayoutActivity;
import com.example.lin.myandroidapplication.ui.casual.CustomViewActivity;
import com.example.lin.myandroidapplication.ui.casual.DownloadActivity;
import com.example.lin.myandroidapplication.ui.casual.EventStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.ExpandRvActivity;
import com.example.lin.myandroidapplication.ui.casual.GsonStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.ListTestActivity;
import com.example.lin.myandroidapplication.ui.casual.LoadTestActivity;
import com.example.lin.myandroidapplication.ui.casual.LoadingActivity;
import com.example.lin.myandroidapplication.ui.casual.LruCacheStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.MPChartStudy2Activity;
import com.example.lin.myandroidapplication.ui.casual.MPchartActivity;
import com.example.lin.myandroidapplication.ui.casual.MultiRecyclerActivity;
import com.example.lin.myandroidapplication.ui.casual.PopRightActivity;
import com.example.lin.myandroidapplication.ui.casual.RVScrollActivity;
import com.example.lin.myandroidapplication.ui.casual.RealmStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.RetrofitActivity;
import com.example.lin.myandroidapplication.ui.casual.RxJavaStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.TabStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.ToolbarActivity;
import com.example.lin.myandroidapplication.ui.casual.TurnSaveStudy;
import com.example.lin.myandroidapplication.ui.casual.VFStudyActivity;
import com.example.lin.myandroidapplication.ui.casual.ViewSwitcherActivity;

import java.util.ArrayList;
import java.util.List;

public class CasualActivity extends BaseRecyclerActivity<ActivityData> {

    private List<ActivityData> mContents;


    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("Turn-Save", "屏幕翻转保存数据", TurnSaveStudy.class));
        mContents.add(new ActivityData("Toolbar", "......", ToolbarActivity.class));
        mContents.add(new ActivityData("PopRight", "从右侧弹出的PopupWindow,仿淘宝筛选", PopRightActivity.class));
        mContents.add(new ActivityData("ViewFlipper", "ViewFlipper使用学习", VFStudyActivity.class));
        mContents.add(new ActivityData("RvScroll-Glide", "RecyclerView滑动时停止加载图片", RVScrollActivity.class));
        mContents.add(new ActivityData("Rv-Expand", "可以展开的RecyclerView联系", ExpandRvActivity.class));
        mContents.add(new ActivityData("Load-Rv", "进入界面时的加载练习", LoadTestActivity.class));
        mContents.add(new ActivityData("Loading-anim", "......", LoadingActivity.class));
        mContents.add(new ActivityData("MultiRecycler", "......", MultiRecyclerActivity.class));
        mContents.add(new ActivityData("CoordinaLayout", "......", CoordinaLayoutActivity.class));
        mContents.add(new ActivityData("CoordinaLayout2", "......", CoordinaLayout2Activity.class));
        mContents.add(new ActivityData("LruCache", "......", LruCacheStudyActivity.class));
        mContents.add(new ActivityData("Retrofit", "......", RetrofitActivity.class));
        mContents.add(new ActivityData("EventBus", "......", EventStudyActivity.class));
        mContents.add(new ActivityData("ViewPager-Anim", "......", AnimViewPagerActivity.class));
        mContents.add(new ActivityData("Behavior", "......", BehaviorStudyActivity.class));
        mContents.add(new ActivityData("MPChart", "......", MPchartActivity.class));
        mContents.add(new ActivityData("MPChart2", "......", MPChartStudy2Activity.class));
        mContents.add(new ActivityData("Tab", "......", TabStudyActivity.class));
        mContents.add(new ActivityData("RxJava", "......", RxJavaStudyActivity.class));
        mContents.add(new ActivityData("Download", "......", DownloadActivity.class));
        mContents.add(new ActivityData("Check In", "......", CheckinActivity.class));
        mContents.add(new ActivityData("ViewSwitcher", "......", ViewSwitcherActivity.class));
        mContents.add(new ActivityData("RealmStudy", "Realm数据库的使用练习", RealmStudyActivity.class));
        mContents.add(new ActivityData("GsonStudy", "Json数据转换联系", GsonStudyActivity.class));
        mContents.add(new ActivityData("自己的自定义View", "自己的自定义View学习", CustomViewActivity.class));
        mContents.add(new ActivityData("LinkedListView", "LinkedListView", ListTestActivity.class));
        mAdapter.setNewData(mContents);
    }

    @Override
    protected String getToolbarTitle() {
        return "随意学习";
    }

    @Override
    protected View getDialogView(String des) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_text_item, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog);
        textView.setText(des);
        return view;
    }


}
