package com.example.myapplication.customview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/12.
 */

public class FlipEffection_17 extends View {
    Bitmap bitmap;
    Paint mPaint;
    int degree = 45;

    /**
     * 为啥从中间翻页的,主动调用setDegree方法
     */
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);

    public FlipEffection_17(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.xin_tou);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    public void setDegree(int degree){
        this.degree = degree;
        //requestLayout();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int imgW = bitmap.getWidth();
        int imgH = bitmap.getHeight();
        int centerX = width / 2;
        int centerY = height /2;
        int x = centerX - imgW / 2;
        int y = centerY - imgH / 2;

        //绘制上半部分
        canvas.save();
        canvas.clipRect(0,0,width,centerY);
        canvas.drawBitmap(bitmap,x,y,mPaint);
        canvas.restore();

        //绘制下半部分
        Camera camera = new Camera();
        canvas.save();

        //方案一
        if (degree < 90) {
            canvas.clipRect(0, centerY, getWidth(), getHeight());
        } else {
            canvas.clipRect(0, 0, getWidth(), centerY);
        }

        camera.save();
        camera.rotateX(degree);
        canvas.translate(centerX,centerY);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.translate(-centerX,-centerY);

        //方案二
        //canvas.drawBitmap(bitmap,new Rect(0,imgH/2,imgW,imgH),new Rect(x,centerY,x+imgW,y+imgH),mPaint);
        canvas.drawBitmap(bitmap,x,y,mPaint);
        canvas.restore();

    }
}
