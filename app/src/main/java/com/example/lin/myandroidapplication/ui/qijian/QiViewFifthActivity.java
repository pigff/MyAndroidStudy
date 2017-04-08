package com.example.lin.myandroidapplication.ui.qijian;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.lin.myandroidapplication.R;

/**
 * ColorMatrix
 * 色彩矩阵
 * ColorMatrix()    // 主要用这个
 * ColorMatrix(float[] src)  // 这个用法参考爱哥的
 * <p>
 * setSaturation(float sat) 设置饱和度
 * setScale(float rScale, float gScale, float bScale, float aScale)  色彩缩放 依次对应RGBA 的缩放 > 1放大 反之
 * setRotate(int axis, float degrees)  色彩旋转
 * 将旋转围绕某一个颜色轴旋转    axis=0 围绕红色旋转 axis=1 围绕绿色轴旋转  axis=2 围绕蓝色轴旋转 degrees表示旋转的度数
 *
 * 第9-10篇部分都可以参考爱哥的部分记录学习
 * ColorMatrixColorFilter
 * 色彩矩阵颜色过滤器
 * LightingColorFilter
 * 光照颜色过滤器  可以简单的完成色彩过滤和色彩增强功能
 * LightingColorFilter(int mul, int add) 例如(new LightingColorFilter(0x00ff00, 0x000000) 过滤红绿，剩蓝
 * new LightingColorFilter(0xffffffff, 0x0000f0) 增强蓝色)
 *
 * PorterDuffColorFilter
 * 图形混合滤镜       参考爱哥的记录学习
 */
public class QiViewFifthActivity extends AppCompatActivity {

    private ImageView mMatrixIv;
    private SeekBar mMatrixFirstSeebar;
    private SeekBar mMatrixSecondSeebar;
    private SeekBar mMatrixThirdSeebar;

    private Bitmap mOriginBmp, mTempBmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_view_fifth);
        initView();
    }

    private void initView() {
        mMatrixIv = (ImageView) findViewById(R.id.matrix_iv);
        mMatrixFirstSeebar = (SeekBar) findViewById(R.id.matrix_first_seebar);
        mOriginBmp = BitmapFactory.decodeResource(getResources(), R.drawable.girl_02);
        mTempBmp = Bitmap.createBitmap(mOriginBmp.getWidth(), mOriginBmp.getHeight(), Bitmap.Config.ARGB_8888);
        mMatrixIv.setImageBitmap(mOriginBmp);
        mMatrixFirstSeebar.setMax(20);
        mMatrixFirstSeebar.setProgress(1);
        mMatrixFirstSeebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bitmap = handleColorMatriBmp(progress);
                mMatrixIv.setImageBitmap(bitmap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private Bitmap handleColorMatriBmp(int progress) {
        Canvas canvas = new Canvas(mTempBmp);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        ColorMatrix staturationMatrix = new ColorMatrix();
        staturationMatrix.setSaturation(progress);
        paint.setColorFilter(new ColorMatrixColorFilter(staturationMatrix));
        canvas.drawBitmap(mOriginBmp, 0, 0, paint);
        return mTempBmp;
    }
}
