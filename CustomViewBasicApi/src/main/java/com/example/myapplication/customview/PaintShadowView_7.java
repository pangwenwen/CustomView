package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/5.
 */

public class PaintShadowView_7 extends View {
    private Context mContext;
    public PaintShadowView_7(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1、shadow
        //在硬件加速开启的情况下， setShadowLayer() 只支持文字的绘制，文字之外的绘制必须关闭硬件加速才能正常绘制阴影。
        // 如果 shadowColor 是半透明的，阴影的透明度就使用 shadowColor 自己的透明度；而如果 shadowColor 是不透明的，阴影的透明度就使用 paint 的透明度
        Paint shadowPaint = new Paint();
        shadowPaint.setTextSize(30);
        shadowPaint.setShadowLayer(2,10,10, Color.GREEN);
        canvas.drawText("胖小文",20,20,shadowPaint);

        //2、
        Bitmap bp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.xin);
        Rect srcRect = new Rect(200,50,500,350);
        Paint mPaint = new Paint();
        BlurMaskFilter.Blur[] blurs = {BlurMaskFilter.Blur.NORMAL, BlurMaskFilter.Blur.INNER, BlurMaskFilter.Blur.OUTER, BlurMaskFilter.Blur.SOLID};
        for (int i=0;i<blurs.length;i++){
            mPaint.setMaskFilter(new BlurMaskFilter(50, blurs[i]));
            Rect decRect = new Rect(50+(i%2)*400,140+(i/2)*400,350+(i%2)*400,340+(i/2)*400);
            canvas.drawBitmap(bp,srcRect,decRect,mPaint);
        }
        //浮雕效果
        //EmbossMaskFilter(float[] direction, float ambient, float specular, float blurRadius) 的参数里， direction 是一个 3 个元素的数组，指定了光源的方向； ambient 是环境光的强度，数值范围是 0 到 1； specular 是炫光的系数； blurRadius 是应用光线的范围
        mPaint.setMaskFilter(new EmbossMaskFilter(new float[]{1,1,1},0.4f,3,10));
        Rect decRect = new Rect(150,800,450,1000);
        canvas.drawBitmap(bp,srcRect,decRect,mPaint);

    }
}
