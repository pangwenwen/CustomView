package com.example.myapplication.customview.evaluator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by hua.pang on 2017/9/18.
 */

public class Evaluator1 extends View {
    private static final String TAG = "Evaluator1";
    /**
     * 关于 ObjectAnimator，上期讲到可以用 ofInt() 来做整数的属性动画和用 ofFloat() 来做小数的属性动画。这两种属性类型是属性动画最常用的两种，不过在实际的开发中，
     * 可以做属相动画的类型还是有其他的一些类型。当需要对其他类型来做属性动画的时候，就需要用到 TypeEvaluator 了。
     */
    Paint paint ;
    int mColor = 0xffff0000;
    boolean isColor;

    PointF pointF = new PointF(0,0);
    public Evaluator1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    public void setColor(int color){
        isColor = true;
        mColor = color;
        invalidate();
    }

    public int getColor(int color){
        return color;
    }

    public void setPosition(PointF position){
        isColor = false;
        this.pointF = position;
        invalidate();
    }

    public PointF getPointF(){
        return pointF;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if (isColor){
            Log.e(TAG, "onDraw: color = "+mColor );
            paint.setColor(mColor);
            canvas.drawCircle(300,100,100,paint);
        }else {
            paint.setColor(mColor);
            canvas.drawCircle(pointF.x*getWidth(),pointF.y*getHeight(),50,paint);

        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
