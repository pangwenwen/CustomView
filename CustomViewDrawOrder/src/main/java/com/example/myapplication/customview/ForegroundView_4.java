package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hua.pang on 2017/9/12.
 */

public class ForegroundView_4 extends ImageView {
    public ForegroundView_4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#ffff00"));
        paint.setTextSize(50);
        paint.setFakeBoldText(true);
        canvas.drawText("BACK",100,100,paint);

        super.onDrawForeground(canvas);

        //paint.setColor(Color.parseColor("#ff00ff"));
        canvas.drawText("FRONT",100,500,paint);
    }
}
