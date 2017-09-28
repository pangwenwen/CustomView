package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/8/29.
 */

/**
 * 自定义绘制的方式是重写绘制方法，其中最常用的是 onDraw()
 *
 * 绘制的关键是 Canvas 的使用
 * Canvas 的绘制类方法： drawXXX() （关键参数：Paint）
 * Canvas 的辅助类方法：clipXXX() 范围裁切和几何变换
 *
 * Paint的使用
 *
 * 可以使用不同的绘制方法来控制遮盖关系
 */
public class CanvasUseView_1 extends View {
    private Context mContext;

    public CanvasUseView_1(Context context) {
        super(context);
    }

    public CanvasUseView_1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //一 drawXXX
         //1- drawColor 、drawRGB 绘制底色、设置绘制半透明蒙板
        canvas.drawColor(Color.parseColor("#30ff0000"));//第二个参数PorterDuff.Mode 绘制模式
        canvas.drawARGB(30,255,0,0);

         //2- draw[graph]
        //圆
        Paint circleP = new Paint();
        circleP.setColor(Color.parseColor("#9000ff00"));
        circleP.setAntiAlias(true);//抗锯齿
        circleP.setStrokeWidth(10);
        circleP.setStyle(Paint.Style.FILL);//FILL:填充；FILL_AND_STROKE；STROKE：只画边
        canvas.drawCircle(100,100,20,circleP);

        circleP.setColor(Color.parseColor("#883300ff"));
        circleP.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(100,100,20,circleP);

        //长方形
        Paint rectP = new Paint();
        rectP.setColor(Color.BLACK);
        canvas.drawRect(200,200,220,220,rectP);
        //圆角长方形
        canvas.drawRoundRect(600,100,650,200,10,10,rectP);

        //Rect:int； RectF:float
        rectP.setColor(Color.RED);
        RectF rectF = new RectF(230,200,250,220);
        canvas.drawRect(rectF,rectP);

        //点
        Paint pointP = new Paint();
        pointP.setColor(Color.BLUE);
        pointP.setStrokeWidth(30);//点的大小
        pointP.setStrokeCap(Paint.Cap.BUTT);//可设置点的形状，主要设置线条端点形状的方法 BUTT:平头；ROUND:圆点；SQUARE：方形
        canvas.drawPoint(270,100,pointP);

        pointP.setStrokeWidth(10);
        pointP.setColor(Color.DKGRAY);
        float[] points = {400,100,300,200,500,200};
        canvas.drawPoints(points,pointP);
        //pts 点的数组；offset 跳过几个，count 画几个点
        //canvas.drawPoints(float[] pts, int offset, int count, Paint paint);

        //椭圆
        Paint ovalP = new Paint();
        ovalP.setAntiAlias(true);
        ovalP.setColor(Color.parseColor("#009389"));
        canvas.drawOval(50,300,150,500,ovalP);

        //画线
        Paint linP = new Paint();
        linP.setStrokeWidth(5);
        linP.setColor(Color.parseColor("#990099"));
        canvas.drawLine(200,300,300,500,linP);

        float[] lines = {500,300,500,500,440,380,560,380};
        linP.setColor(Color.parseColor("#223344"));
        canvas.drawLines(lines,linP);

        //画弧
        Paint arcP = new Paint();
        arcP.setStrokeWidth(5);
        arcP.setStyle(Paint.Style.STROKE);
        arcP.setColor(Color.parseColor("#ff0000"));
        //drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
        //left,top,right,bottom 表示弧形所在椭圆的上下左右，x轴方向为正0度，顺时针为正逆时针为负 startAngle：开始的角度，sweepAngle 转过的角度 useCenter：是否连接圆心，连接为扇形，不连为弧形
        canvas.drawArc(50,600,200,700,0,100,true,arcP);
        canvas.drawLine(0,700,200,700,arcP);

        //四、画bitmap
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#9911ff"));
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.xin);
        int bW = bitmap.getWidth();
        int bH = bitmap.getHeight();

        Rect resR = new Rect(bW/3,100,bW*2/3,bH-100);
        Rect desR = new Rect(300,600,400,800);
        //Rect src:切割图片的矩形， Rect dst：在画布上的位置，切割的图片随画布上的大小伸缩
        canvas.drawBitmap(bitmap,resR,desR,paint);

        //五、 写字
        paint.setTextSize(20);
        canvas.drawText("hello，xiaoxin",280,850,paint);

    }
}
