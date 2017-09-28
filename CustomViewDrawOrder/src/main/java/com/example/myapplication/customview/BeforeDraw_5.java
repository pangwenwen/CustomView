package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/**
 * Created by hua.pang on 2017/9/12.
 */

public class BeforeDraw_5 extends EditText {

    public BeforeDraw_5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#600000ff"));
        super.draw(canvas);
    }
}
