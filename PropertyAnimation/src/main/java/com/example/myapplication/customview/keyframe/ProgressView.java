package com.example.myapplication.customview.keyframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/19.
 */

public class ProgressView extends View {
    private static final String TAG = "ProgressView";
    Paint progresspaint;
    Paint textPaint;
    int progress;
    RectF rectf;

    int centerX;
    int centerY;

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        progresspaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progresspaint.setColor(Color.parseColor("#ff0011"));
        progresspaint.setStyle(Paint.Style.STROKE);
        progresspaint.setStrokeWidth(10);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(30);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public int getProgress() {
        return progress;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        centerX = getMeasuredWidth() / 2;
        centerY = getHeight() / 2;
        Log.d(TAG, "onAttachedToWindow: getWidth() = "+getMeasuredWidth());

        rectf = new RectF(350-200,400-200,350+200,400+200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: progress = "+progress);

        canvas.drawArc(rectf,135,progress*2.7f,false,progresspaint);
        //if (progress == (int)progress){
            String percent = progress+"%";
            Rect rect = new Rect();
            textPaint.getTextBounds(percent,0,percent.length(),rect);
            canvas.drawText(percent,350-rect.width()/2,400-rect.height()/2,textPaint);
        //}
    }
}
