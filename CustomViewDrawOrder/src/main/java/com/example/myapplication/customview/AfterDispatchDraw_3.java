package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by hua.pang on 2017/9/12.
 */

public class AfterDispatchDraw_3 extends LinearLayout {
    public AfterDispatchDraw_3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#60ff00ff"));

        canvas.drawCircle(200,200,50,paint);
        canvas.drawCircle(500,600,80,paint);
        canvas.drawCircle(100,500,100,paint);

    }
}
