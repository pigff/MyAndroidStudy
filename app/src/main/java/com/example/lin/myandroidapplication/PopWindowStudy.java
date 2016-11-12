package com.example.lin.myandroidapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lin on 2016/11/12.
 */
public class PopWindowStudy extends AppCompatActivity implements View.OnClickListener {

    //定义不同颜色的菜单项的标识
    private final int RED = 110;
    private final int GREEN = 111;
    private final int BLUE = 112;
    private final int YELLOW = 113;
    private int GRAY = 114;
    private int CYAN = 115;
    private int BLACK = 116;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popwindow_layout);
        initView();
        initMenuView();
    }

    private void initMenuView() {
        mTextView = (TextView) findViewById(R.id.pop_text_01);
        TextView showMenuText = (TextView) findViewById(R.id.pop_text_02);
        registerForContextMenu(showMenuText);
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.pop_btn_01);
        button.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.pop_btn_02);
        button1.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, RED, 4, "红色");
        menu.add(1, GREEN, 2, "绿色");
        menu.add(1, BLUE, 3, "蓝色");
        menu.add(1, YELLOW, 1, "黄色");
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater inflater = new MenuInflater(this);
//        inflater.inflate(R.menu.menu_02, menu);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_03, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.blue:
//                mTextView.setTextColor(Color.BLUE);
//                break;
//            case R.id.green:
//                mTextView.setTextColor(Color.GREEN);
//                break;
//            case R.id.red:
//                mTextView.setTextColor(Color.RED);
//                break;
//            default:
//                break;
//        }
        switch (item.getItemId()) {
            case R.id.submenu:
                Toast.makeText(this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.one:
                Toast.makeText(this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.three:
                Toast.makeText(this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case RED:
                mTextView.setTextColor(Color.RED);
                break;
            case GREEN:
                mTextView.setTextColor(Color.GREEN);
                break;
            case BLUE:
                mTextView.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                mTextView.setTextColor(Color.YELLOW);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pop_btn_01:
                initPopWindow(v);
                break;
            case R.id.pop_btn_02:
                PopupMenu popupMenu = new PopupMenu(PopWindowStudy.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_02, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.blue:
                                Toast.makeText(PopWindowStudy.this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.green:
                                Toast.makeText(PopWindowStudy.this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.red:
                                Toast.makeText(PopWindowStudy.this, "item.getTitle():" + item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                break;
            default:
                break;
        }
    }

    private void initPopWindow(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_pop, null, false);
        Button button1 = (Button) view.findViewById(R.id.item_pop_btn_01);
        Button button2 = (Button) view.findViewById(R.id.item_pop_btn_02);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.anim.anim_pop);//设置加载动画

        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000)); //要为popWindow设置一个背景才有效
        popupWindow.showAsDropDown(v, 50, 0);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopWindowStudy.this, "嘻嘻~", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopWindowStudy.this, "哈哈~", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
