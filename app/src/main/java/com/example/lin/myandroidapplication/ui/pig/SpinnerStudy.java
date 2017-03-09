package com.example.lin.myandroidapplication.ui.pig;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.CommonAdapter;
import com.example.lin.myandroidapplication.data.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/11/4.
 */
public class SpinnerStudy extends Activity {

    private Spinner mSpinner;
    private Spinner mSpinner2;
    private List<Role> mRoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_layout);
        mSpinner = (Spinner) findViewById(R.id.spin_01);
        mSpinner2 = (Spinner) findViewById(R.id.spin_02);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerStudy.this, "parent.getItemAtPosition(position):" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mRoles = new ArrayList<>();
        mRoles.add(new Role("http://img2.imgtn.bdimg.com/it/u=51907720,2626938034&fm=21&gp=0.jpg", "路飞"));
        mRoles.add(new Role("http://img1.imgtn.bdimg.com/it/u=1170976642,3202391143&fm=21&gp=0.jpg", "索隆"));
        mRoles.add(new Role("http://img5.imgtn.bdimg.com/it/u=2677438217,1997849818&fm=21&gp=0.jpg", "山治"));
        CommonAdapter<Role> adapter = new CommonAdapter<Role>(mRoles, R.layout.lv_item) {
            @Override
            public void bindView(ViewHolder holder, Role obj) {
                holder.setText(R.id.right_item, obj.getName());
                Glide.with(SpinnerStudy.this).load(obj.getIcon()).into((ImageView) holder.getView(R.id.left_item));
            }
        };
        mSpinner2.setAdapter(adapter);

        //
        AutoCompleteTextView completeTextView = (AutoCompleteTextView) findViewById(R.id.complete_01);
        MultiAutoCompleteTextView autoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.complete_02);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(SpinnerStudy.
                this, android.R.layout.simple_dropdown_item_1line, data);
        completeTextView.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SpinnerStudy.this, android.R.layout.simple_dropdown_item_1line, data);
        autoCompleteTextView.setAdapter(adapter2);
        autoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    private static final String[] data = new String[]{
            "小猪猪", "小狗狗", "小鸡鸡", "小猫猫", "小咪咪"
    };


}
