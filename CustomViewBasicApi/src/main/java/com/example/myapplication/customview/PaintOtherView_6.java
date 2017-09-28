package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/5.
 */

public class PaintOtherView_6 extends View {
    private Context mContext;
    public PaintOtherView_6(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(30);

        paint.setStyle(Paint.Style.STROKE);
        //一、线条形状
        //1.线条宽度
        paint.setStrokeWidth(5);
        //2. 线头形状
        paint.setStrokeCap(Paint.Cap.BUTT);
        //3. 设置拐角处形状
        // BEVEL:平角；MITER:尖角；ROUND：圆角。默认为MITER，当如果拐角的大小为 θ ，那么这个比值就等于 1 / sin ( θ / 2 ) ，默认为4，大于4时设置为平角;setStrokeMiter设置最大值
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeMiter(6f);

        Path path = new Path();
        path.lineTo(50,100);
        path.rLineTo(50,-100);
        canvas.drawPath(path,paint);

        canvas.drawText("Shape Style",110,50,textPaint);

        Bitmap bp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.xin);
        //二、色彩效果
         // 1.抖动 抖动更多的作用是在图像降低色彩深度绘制时，避免出现大片的色带与色块
        paint.setDither(true);

         //2. 双线性过滤 图像在放大绘制的时候，默认使用的是最近邻插值过滤，这种算法简单，但会出现马赛克现象；而如果开启了双线性过滤，就可以让结果图像显得更加平滑
        paint.setFilterBitmap(true);

        Rect sRect = new Rect(100,140,110,150);
        Rect dRect = new Rect(0,120,200,320);
        canvas.drawBitmap(bp,sRect,dRect,paint);

        paint.setFilterBitmap(false);
        Rect dRect2 = new Rect(250,120,470,320);
        canvas.drawBitmap(bp,sRect,dRect2,paint);
        canvas.drawText("Color Style",500,250,textPaint);
        canvas.drawLine(0,330,800,330,paint);

        //三、 线条效果
        Paint Lpaint = new Paint();
        Lpaint.setStrokeWidth(5);
        Lpaint.setStyle(Paint.Style.STROKE);
        Lpaint.setAntiAlias(true);

         //1. 圆角效果
        CornerPathEffect cEffect = new CornerPathEffect(30);
        //2. 虚线 DashPathEffect(float[] intervals, float phase) intervals:虚线的长度和间隔；phase:偏移量
        DashPathEffect dEffect = new DashPathEffect(new float[]{10f,5f,1f,5f},0);
        //3. 随机的偏离 (float segmentLength, float deviation) segmentLength：线段长度；deviation：偏移量
        DiscretePathEffect disEffect = new DiscretePathEffect(5,3);
        //4. 形状组合(Path shape, float advance, float phase, PathDashPathEffect.Style style) shape:形状；advance：距离（起点和起点）；phase:偏移量
        //style:TRANSLATE：位移;ROTATE：旋转; MORPH：变体
        Path path3 = new Path();
        path3.addRect(0,0,10,10, Path.Direction.CW);
        PathDashPathEffect pEffect = new PathDashPathEffect(path3,15,0, PathDashPathEffect.Style.ROTATE);
        //5. 组合
        SumPathEffect sEffect = new SumPathEffect(dEffect,disEffect);
        //6. 结合
        ComposePathEffect comEffect = new ComposePathEffect(dEffect,disEffect);

        PathEffect[] patheffect = {cEffect,dEffect,disEffect,pEffect,sEffect,comEffect};
        for (int i = 0;i<patheffect.length;i++){
            Path path2 = new Path();
            path2.moveTo(0+200*(i%3),350+250*(i/3));
            path2.lineTo(30+200*(i%3),550+250*(i/3));
            path2.lineTo(50+200*(i%3),400+250*(i/3));
            path2.lineTo(80+200*(i%3),480+250*(i/3));
            path2.lineTo(120+200*(i%3),360+250*(i/3));
            Lpaint.setPathEffect(patheffect[i]);
            canvas.drawPath(path2,Lpaint);
        }

        canvas.drawLine(0,620,800,620,paint);


    }
}
