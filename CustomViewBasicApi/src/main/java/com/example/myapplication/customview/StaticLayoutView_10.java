package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/8.
 */

public class StaticLayoutView_10 extends View {
    private String mText = "xiao pang hua xiao pang hua xiao pang hua xiao pang hua xiao pang hua";
    Paint  mPaint;

    public StaticLayoutView_10(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(50);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //普通的绘制不能换行，使用此api控制长度，让文字换行，也可在添加\n的位置换行
        //(CharSequence source, TextPaint paint, int width, Alignment align, float spacingmult, float spacingadd, boolean includepad)
        //width:行宽；Alignment：文字对齐方向；spacingmult:行间距的倍数，通常为1；spacingadd :行间距的额外增加值；includepad：否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越

        TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(36);
        StaticLayout staticLayout = new StaticLayout(mText,paint,500, Layout.Alignment.ALIGN_CENTER,1,0,true);
        //canvas.save();
        //canvas.translate(0,50);
        staticLayout.draw(canvas);
        //canvas.restore();
        mPaint.setColor(Color.RED);
        canvas.drawText("控制文字换行",100,500,mPaint);

    }
}
