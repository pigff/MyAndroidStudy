package com.example.lin.myandroidapplication.widget.qijian.porter1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;

/**
 * Created by qijian on 16/4/15.
 * 遮罩是一个从上到下的白色填充渐变；白色的透明度从49%到0
 */
public class InvertedImageView_SRCIN  extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST,BmpSRC,BmpRevert;
    public InvertedImageView_SRCIN(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mBitPaint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(),R.drawable.dog_invert_shade,null);
        BmpSRC = BitmapFactory.decodeResource(getResources(), R.drawable.dog,null);

        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);
        // 生成倒影图
        BmpRevert = Bitmap.createBitmap(BmpSRC, 0, 0, BmpSRC.getWidth(), BmpSRC.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //先画出小狗图片
        canvas.drawBitmap(BmpSRC,0,0,mBitPaint);

        //再画出倒影
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.translate(0,BmpSRC.getHeight());

        canvas.drawBitmap(BmpDST,0,0,mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(BmpRevert,0,0,mBitPaint);

        mBitPaint.setXfermode(null);

        canvas.restoreToCount(layerId);
    }
}
