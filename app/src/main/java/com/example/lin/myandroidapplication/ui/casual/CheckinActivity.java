package com.example.lin.myandroidapplication.ui.casual;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.SignInAdapter;
import com.example.lin.myandroidapplication.data.SignDayListBean;
import com.example.lin.myandroidapplication.widget.RecyclerViewItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CheckinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        init();
    }

    private void init() {
        List<SignDayListBean> listBeen = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            listBeen.add(new SignDayListBean());
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_checkin);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        recyclerView.addItemDecoration(new RecyclerViewItemDecoration(RecyclerViewItemDecoration.MODE_GRID, Color.LTGRAY, 2, 0, 0));
        SignInAdapter adapter = new SignInAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(listBeen);
        adapter.notifyDataSetChanged();

        Button button1 = (Button) findViewById(R.id.btn_success);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInDoneDialog();
            }
        });
        Button button2 = (Button) findViewById(R.id.btn_notice);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInAlertDialog();
            }
        });
    }

    private void showSignInAlertDialog() {
        final Dialog dialog = new Dialog(this, R.style.dialog);
        View view = View.inflate(CheckinActivity.this, R.layout.dialog_sign_in_alert, null);
        Button btn = (Button) view.findViewById(R.id.btn_sign_in_alert);
        final Switch swch = (Switch) view.findViewById(R.id.swich_item_sign_in_alert);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                NotificationUtils.sendMsg(SignInActivity2.this,R.mipmap.sign_in_alert_on,"title","");
                dialog.dismiss();
            }
        });

        dialog.setContentView(view);
        dialog.show();
    }


    private void showSignInDoneDialog() {
        Dialog dialog = new Dialog(this, R.style.dialog);
        View view = View.inflate(CheckinActivity.this, R.layout.dialog_sign_in_done, null);
        TextView tvTodayNum = (TextView) view.findViewById(R.id.tv_today_num_dialog_sign_in_done);
        TextView tvTotalSignNum = (TextView) view.findViewById(R.id.tv_total_dialog_sign_in_done);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_sign_num_today_dialog);
        LinearLayout llTotal = (LinearLayout) view.findViewById(R.id.ll_sign_num_total_dialog);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) llTotal.getLayoutParams();

//        if(type == SIGN_IN_TYPE){
//            linearLayout.setVisibility(View.VISIBLE);
//            layoutParams.setMargins(0,0,0,0);
//        }else if(type == RESIGN_IN_TYPE){
//            linearLayout.setVisibility(View.GONE);
//            layoutParams.setMargins(0, Tools.dip2px(SignInActivity2.this,77),0,0);
//        }
//
        tvTodayNum.setText("12");
        tvTotalSignNum.setText("13");

        dialog.setContentView(view);
        dialog.show();

    }
}
