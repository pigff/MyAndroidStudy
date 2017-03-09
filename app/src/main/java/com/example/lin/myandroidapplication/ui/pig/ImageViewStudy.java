package com.example.lin.myandroidapplication.ui.pig;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.MyCircleImg;

/**
 * Created by greedy on 16/10/31.
 */
public class ImageViewStudy extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_layout);
        ImageView imageView = (ImageView) findViewById(R.id.img_05);
        ImageView imageView1 = (ImageView) findViewById(R.id.img_06);
        MyCircleImg roundImg = (MyCircleImg) findViewById(R.id.round_img);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        roundImg.setBitmap(bitmap);
        ImageView imageView2 = (ImageView) findViewById(R.id.glide_img);
        Glide.with(this).load("http://img4.imgtn.bdimg.com/it/u=3217962789,3430649993&fm=21&gp=0.jpg").into(imageView2);
    }
}
