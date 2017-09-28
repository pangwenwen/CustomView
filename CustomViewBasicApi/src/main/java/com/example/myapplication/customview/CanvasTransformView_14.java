package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/11.
 */

public class CanvasTransformView_14 extends View {
    Bitmap bitmap;
    Paint mPaint;
    public CanvasTransformView_14(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.xin_tou);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 移动的是canvas的原点，旋转的是屏幕坐标系
        //1. 平移
        canvas.save();
        canvas.translate(300,0);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();

        //2. 旋转
        canvas.save();
        canvas.rotate(45);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();

        //3. 伸缩
        canvas.save();
        canvas.scale(2.0f,0.8f);
        canvas.drawBitmap(bitmap,100,400,mPaint);
        canvas.restore();

        //4. 错切 sx:在x轴旋转的角度的tan值，sy:在y轴旋转的角度tan值
        canvas.save();
        canvas.skew(0.5f,1f);
        canvas.drawBitmap(bitmap,100,400,mPaint);
        canvas.restore();

        canvas.save();
        canvas.skew(1f,0.5f);
        canvas.drawBitmap(bitmap,0,400,mPaint);
        canvas.restore();

        //5. 组合 顺序是倒置的
        canvas.save();
        canvas.translate(300,600);
        canvas.rotate(45);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();

        canvas.save();
        canvas.rotate(45);
        canvas.translate(300,300);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();


    }
}
