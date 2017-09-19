package com.example.myapplication.customview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/13.
 * ProjectPropertyAnimation 的基本使用
 */

public class ProjectPropertyAnimation_1 extends View {
    Paint paint = new Paint();
    RectF rect;
    int degree;

    Paint textPaint = new Paint();

    public ProjectPropertyAnimation_1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10);
        paint.setColor(Color.parseColor("#80ff11ff"));

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(30);
        textPaint.setFakeBoldText(true);

        rect = new RectF(200, 200, 600, 600);
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    public int getDegree() {
        return degree;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "degree", 0, 70).setDuration(5000);
        objectAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(rect, 135, degree * 2.7f, false, paint);

        String degreeS = degree + "%";
        Rect rect = new Rect();
        textPaint.getTextBounds(degreeS, 0, degreeS.length(), rect);
        int x = 400 - rect.width() / 2;
        int y = 400 - rect.height() / 2;
        canvas.drawText(degreeS, x, y, textPaint);
    }
}
