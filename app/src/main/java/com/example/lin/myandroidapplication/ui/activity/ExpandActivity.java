package com.example.lin.myandroidapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;

public class ExpandActivity extends AppCompatActivity {


    private String[] mParentGroup;
    private String[][] mChildGroup;
    private int mSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);
        final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expan_01);
        initData();
        MyAdapter adapter = new MyAdapter();
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (mChildGroup[groupPosition].length == 0) {
                    return false;
                } else {
                    if (mSign == -1) {
                        expandableListView.expandGroup(groupPosition);
                        expandableListView.setSelectedGroup(groupPosition);
                        mSign = groupPosition;
                    } else if (mSign == groupPosition) {
                        expandableListView.collapseGroup(mSign);
                        mSign = -1;
                    } else {
                        expandableListView.collapseGroup(mSign);
                        expandableListView.expandGroup(groupPosition);
                        expandableListView.expandGroup(groupPosition);
                        mSign = groupPosition;
                    }
                    return true;
                }
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i < mParentGroup.length; i++) {
                    if (groupPosition != i) {
                        expandableListView.collapseGroup(i);
                    }
                }
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }

    private void initData() {
        mSign = -1;
        mParentGroup = new String[]{"火影", "海贼", "死神"};
        mChildGroup = new String[][]{{"鸣人", "佐助"},
                {"路飞", "香吉士", "索隆"},
                {"黑崎一护", "井上"}};

    }

    class MyAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return mParentGroup.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mChildGroup[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mParentGroup[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mChildGroup[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ParentHolder holder;
            if (convertView == null) {
                holder = new ParentHolder();
                convertView = LayoutInflater.from(ExpandActivity.this).inflate(R.layout.parent_item, parent, false);
                holder.mParentTv = (TextView) convertView.findViewById(R.id.parent_tv);
                convertView.setTag(holder);
            } else {
                holder = (ParentHolder) convertView.getTag();
            }
            holder.mParentTv.setText(mParentGroup[groupPosition]);
            //  elistview.setGroupIndicator(null);//将控件默认的左边箭头去掉，
            //  然后通过isExpanded参数来判断图片显示的方式
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = LayoutInflater.from(ExpandActivity.this).inflate(R.layout.child_item, parent, false);
                holder.mChildTv = (TextView) convertView.findViewById(R.id.child_tv);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }
            holder.mChildTv.setText(mChildGroup[groupPosition][childPosition]);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        class ParentHolder {
            TextView mParentTv;
        }

        class ChildHolder {
            TextView mChildTv;
        }
    }
}
