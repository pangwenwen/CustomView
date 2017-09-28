package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hua.pang on 2017/9/12.
 */

public class BeforeOnDraw_2 extends TextView {
    public BeforeOnDraw_2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int count = getLineCount();
        Layout layout = getLayout();
        float rect1L = layout.getLineLeft(0);
        float rect1T = layout.getLineTop(0);
        float rect1R = layout.getLineRight(0);
        float rect1B = layout.getLineBottom(0);

        float rectEL = layout.getLineLeft(count-1);
        float rectET = layout.getLineTop(count-1);
        float rectER = layout.getLineRight(count-1);
        float rectEB = layout.getLineBottom(count-1);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff00ff"));
        canvas.drawRect(rect1L,rect1T,rect1R,rect1B,paint);
        canvas.drawRect(rect1L,rectET,rectER,rectEB,paint);

        /*此方法测试的不准确，会设置整行的背景，包括没有文字的位置
        Rect rect0 = new Rect();
        getLineBounds(0,rect0);
        Rect rectE = new Rect();
        getLineBounds(count-1,rectE);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff00ff"));
        canvas.drawRect(rect0,paint);
        canvas.drawRect(rectE,paint);*/

        super.onDraw(canvas);
    }
}
