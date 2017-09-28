package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/8.
 */

public class TextStyleView_11 extends View {
    private String mText = "xiao pang hua xiao pang hua xiao ";
    Paint mPaint;
    Typeface mTypeface;
    public TextStyleView_11(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(36);

        mTypeface = Typeface.createFromAsset(getContext().getAssets(),"Satisfy-Regular.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //1. typeface
        mPaint.setTypeface(mTypeface);
        canvas.drawText(mText,0,50,mPaint);

        //2.文字的对齐方式
        mPaint.reset();
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText,0,100,mPaint);


        //3. 加粗
        mPaint.reset();
        mPaint.setTextSize(36);
        mPaint.setFakeBoldText(true);
        canvas.drawText(mText,0,200,mPaint);

        //4. 添加删除线
        mPaint.reset();
        mPaint.setStrikeThruText(true);
        canvas.drawText(mText,0,300,mPaint);

        //5.添加下滑线
        mPaint.reset();
        mPaint.setUnderlineText(true);
        canvas.drawText(mText,0,400,mPaint);

        //6. 文字倾斜
        mPaint.reset();
        mPaint.setTextSkewX(0.3f);
        canvas.drawText(mText,0,500,mPaint);

        //7. 文字在x轴方向伸缩
        mPaint.reset();
        mPaint.setTextScaleX(1.2f);
        canvas.drawText(mText,0,600,mPaint);

        //8. 字fu间距
        mPaint.reset();
        mPaint.setLetterSpacing(1);
        canvas.drawText(mText,0,700,mPaint);



        //10. 字体微调
        mPaint.reset();
        mPaint.setHinting(Paint.HINTING_ON);
        mPaint.setTextSize(26);
        canvas.drawText(mText,0,850,mPaint);

        //11. 次级抗锯齿
        mPaint.reset();
        mPaint.setSubpixelText(true);
        mPaint.setTextSize(46);
        canvas.drawText(mText,0,900,mPaint);

        //12在Android中文本的绘制需要使用一个bitmap作为单个字符的缓存，既然是缓存必定要使用一定的空间，我们可以通过setLinearText (true)告诉Android我们不需要这样的文本缓存
        mPaint.reset();
        mPaint.setLinearText(true);
        canvas.drawText(mText,0,1000,mPaint);

    }
}
