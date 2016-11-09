package com.example.lin.myandroidapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by lin on 2016/11/4.
 */
public class DialogStudy extends Activity implements View.OnClickListener {

    private AlertDialog.Builder mBuilder;
    private AlertDialog mDialog;

    private ProgressDialog pd1 = null;
    private ProgressDialog pd2 = null;
    private final static int MAXVALUE = 100;
    private int progressStart = 0;
    private int add = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_layout);
        Button button1 = (Button) findViewById(R.id.show_dialog_btn_01);
        Button button2 = (Button) findViewById(R.id.show_dialog_btn_02);
        Button button3 = (Button) findViewById(R.id.show_dialog_btn_03);
        Button button4 = (Button) findViewById(R.id.show_dialog_btn_04);
        Button button5 = (Button) findViewById(R.id.show_dialog_btn_05);
        Button button6 = (Button) findViewById(R.id.show_dialog_btn_06);
        Button button7 = (Button) findViewById(R.id.show_dialog_btn_07);
        Button button8 = (Button) findViewById(R.id.show_dialog_btn_08);
        Button button9 = findViewById(R)
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
    }

    //定义一个用于更新进度的Handler,因为只能由主线程更新界面,所以要用Handler传递信息
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            if(msg.what == 123)
            {
                //设置进度条的当前值
                pd2.setProgress(progressStart);
            }
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(progressStart >= MAXVALUE)
            {
                pd2.dismiss();
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_dialog_btn_01:
                normalDialog();
                break;
            case R.id.show_dialog_btn_02:
                listDialog();
                break;
            case R.id.show_dialog_btn_03:
                singleDialog();
                break;
            case R.id.show_dialog_btn_04:
                MultiDialog();
                break;
            case R.id.show_dialog_btn_05:
                customDialog();
                break;
            case R.id.show_dialog_btn_06:
                pd1 = new ProgressDialog(this);
                pd1.show(this, "资源加载中", "资源加载中,请稍后...", false, true);
                break;
            case R.id.show_dialog_btn_07:
                pd1 = new ProgressDialog(this);
                //依次设置标题,内容,是否用取消按钮关闭,是否显示进度
                pd1.setTitle("软件更新中");
                pd1.setMessage("软件正在更新中,请稍后...");
                pd1.setCancelable(true);
                //这里是设置进度条的风格,HORIZONTAL是水平进度条,SPINNER是圆形进度条
                pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd1.setIndeterminate(true);
                //调用show()方法将ProgressDialog显示出来
                pd1.show();
                break;
            case R.id.show_dialog_btn_08:
                //初始化属性
                progressStart = 0;
                add = 0;
                //依次设置一些属性
                pd2 = new ProgressDialog(this);
                pd2.setMax(MAXVALUE);
                pd2.setTitle("文件读取中");
                pd2.setMessage("文件加载中,请稍后...");
                //这里设置为不可以通过按取消按钮关闭进度条
                pd2.setCancelable(false);
                pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //这里设置的是是否显示进度,设为false才是显示的哦！
                pd2.setIndeterminate(false);
                pd2.show();
                //这里的话新建一个线程,重写run()方法,
                new Thread() {
                    public void run() {
                        while (progressStart < MAXVALUE) {
                            //这里的算法是决定进度条变化的,可以按需要写
                            progressStart = 2 * usetime();
                            //把信息码发送给handle让更新界面
                            hand.sendEmptyMessage(123);
                        }
                    }
                }.start();
                break;
            default:
                break;
        }
    }

    //这里设置一个耗时的方法:
    private int usetime() {
        add++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return add;
    }

    private void normalDialog() {
        mDialog = null;
        mBuilder = new AlertDialog.Builder(this);
        mDialog = mBuilder.setIcon(R.drawable.ic_action_emo_evil)
                .setTitle("系统提示")
                .setMessage("这里带有三个按钮")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(DialogStudy.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogStudy.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogStudy.this, "你点击了中立按钮", Toast.LENGTH_SHORT).show();
                    }
                }).create();
        mDialog.show();
    }

    private void listDialog() {
        final String[] lesson = new String[]{"语文", "数学", "英语", "化学", "生物", "物理", "体育"};
        mDialog = null;
        mBuilder = new AlertDialog.Builder(this);
        mDialog = mBuilder.setIcon(R.drawable.ic_action_emo_cool)
                .setTitle("选择你喜欢的课程")
                .setItems(lesson, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogStudy.this, "你选择了:" + lesson[which], Toast.LENGTH_SHORT).show();
                    }
                }).create();
        mDialog.show();
    }

    private void singleDialog() {
        final String[] fruits = new String[]{"苹果", "雪梨", "香蕉", "葡萄", "西瓜"};
        mDialog = null;
        mBuilder = new AlertDialog.Builder(this);
        mDialog = mBuilder.setIcon(R.drawable.ic_tur_icon)
                .setSingleChoiceItems(fruits, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogStudy.this, "你选择了:" + fruits[which], Toast.LENGTH_SHORT).show();
                    }
                }).create();
        mDialog.show();
    }

    private void MultiDialog() {
        final String[] menu = new String[]{"水煮豆腐", "萝卜牛腩", "酱油鸡", "胡椒猪肚鸡"};
        final boolean[] checkItems = new boolean[]{false, false, false, false};
        mDialog = null;
        mBuilder = new AlertDialog.Builder(this);
        mDialog = mBuilder.setIcon(R.drawable.ic_action_emo_cool)
                .setMultiChoiceItems(menu, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkItems[which] = isChecked;
                        Log.d("DialogStudy", which + ": " + isChecked);
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0; i < checkItems.length; i++) {
                            if (checkItems[i])
                                result += menu[i] + " ";
                        }
                        Toast.makeText(DialogStudy.this, "你点了:" + result, Toast.LENGTH_SHORT).show();
                    }
                }).create();
        mDialog.show();
    }

    private void customDialog() {
        mDialog = null;
        mBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_item, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.dialg_img);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.dialg_cancle_img);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });
        Glide.with(this).load("http://img1.imgtn.bdimg.com/it/u=1170976642,3202391143&fm=21&gp=0.jpg").into(imageView);
        mDialog = mBuilder.setView(view)
                .create();
        mDialog.show();
    }
}
