package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/8.
 */

public class DrawTextPathView_9 extends View {
    private String mText = "xiao pang hua xiao pang hua xiao pang hua";
    private Paint mPaint;

    public DrawTextPathView_9(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1. 普通绘制,文字的基准点是在文字的左下角
        mPaint.setTextSize(36);
        canvas.drawText(mText,0,100,mPaint);

        //2. 沿线绘制
        Path path = new Path();
        path.moveTo(0,200);
        path.lineTo(50,500);
        path.lineTo(150,300);
        //mPaint.setStrokeWidth(10);
        //mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path,mPaint);

        //drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
        //hOffset :竖直方向的偏移量；vOffset：顺平方向的偏移量
        canvas.drawTextOnPath(mText,path,0,0,mPaint);
    }
}
