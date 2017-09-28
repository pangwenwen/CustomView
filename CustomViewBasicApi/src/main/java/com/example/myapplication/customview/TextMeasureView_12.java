package com.example.myapplication.customview;

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
 * Created by hua.pang on 2017/9/8.
 */

public class TextMeasureView_12 extends View {
    private String mText = "xiao pang hua xiao pang hua xiao ";
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TextMeasureView_12(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(50);

        //1.获取推荐的行距，两条baseline之间的据林
        float space = mPaint.getFontSpacing();
        canvas.drawText(space+"",0,50,mPaint);

        canvas.drawText(mText,0,100,mPaint);
        //2.获取FontMetrics测量
        Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
        float ascent = fontMetrics.ascent;
        float descent = fontMetrics.descent;
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        //上行的 bottom 线和下行的 top 线的距离
        float leading = fontMetrics.leading;

        mPaint.setColor(Color.RED);
        canvas.drawLine(0,100+ascent,600,100+ascent,mPaint);
        canvas.drawLine(0,100+descent,600,100+descent,mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(0,100+top,600,100+top,mPaint);
        canvas.drawLine(0,100+bottom,600,100+bottom,mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(0,leading,600,leading,mPaint);

        //3. 获取text bound ，完全是文字的边界
        mPaint.setTextSize(36);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText(mText,0,250,mPaint);
        Rect rect = new Rect();
        mPaint.getTextBounds(mText,0,mText.length(),rect);
        int rLeft = rect.left;
        int rRight = rect.right;
        int rTop = rect.top+250;
        int rBottom = rect.bottom+250;
        canvas.drawRect(rLeft,rTop,rRight,rBottom,mPaint);

        //4. 获取的长度包括文字一点点的边界
        canvas.drawText(mText,0,350,mPaint);
        float x = mPaint.measureText(mText);
        canvas.drawLine(0,350,x,350,mPaint);

        //5. 获取每个字符的宽度s
        //mPaint.getTextWidths(mText,new float[]{});

        //6. 折行判断 measureForwards:测量的方向；
        float[] textW = new float[]{};
        int count;
        count = mPaint.breakText(mText,0,mText.length(),true,200,textW);
        canvas.drawText(mText,0,count,0,450,mPaint);

        count = mPaint.breakText(mText,0,mText.length(),false,150,textW);
        canvas.drawText(mText,mText.length()-count,mText.length(),0,550,mPaint);

        //7. 光标相关
        float cursor = mPaint.getRunAdvance(mText,0,mText.length(),0,mText.length(),false,5);
        canvas.drawText(mText,0,650,mPaint);
        canvas.drawLine(cursor,650+ascent,cursor,650+descent,mPaint);

        //8. 判断文案中是否有某个单独的字符
        boolean hasG = mPaint.hasGlyph("x");
        canvas.drawText(hasG+"",0,750,mPaint);


    }
}
