package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/5.
 */

public class PaintPathView_8 extends View {
    Paint textSourcePaint;
    Path textPath;
    Paint pathSourcePaint;
    Paint pathPathPaint;

    Path pathS;
    Path pathS2;
    Path pathS3;
    Path path1;
    Path path2;
    Path path3;

    private String text = "小庞华";

    public PaintPathView_8(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        textSourcePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textSourcePaint.setTextSize(50);
        textSourcePaint.setStrokeWidth(5);
        textSourcePaint.setStyle(Paint.Style.STROKE);
        //textSourcePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPath = new Path();

        pathSourcePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);



        pathS = new Path();
        pathS.moveTo(0,200);
        pathS.lineTo(100,400);
        pathS.lineTo(150,300);
        pathS.lineTo(250,400);
        pathS.lineTo(300,200);

        path1 = new Path();
        path2 = new Path();
        path3 = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //1. 获取字的path
        textSourcePaint.getTextPath(text,0,text.length(),200,50,textPath);
        canvas.drawText(text,0,50,textSourcePaint);
        textSourcePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(textPath,new Paint(Paint.ANTI_ALIAS_FLAG));

        //2. 画线
        pathSourcePaint.getFillPath(pathS,path1);
        canvas.drawPath(pathS,pathSourcePaint);

        canvas.save();
        canvas.translate(400,0);
        canvas.drawPath(path1,pathPathPaint);
        canvas.restore();

        pathSourcePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        pathSourcePaint.setStrokeWidth(10);
        canvas.save();
        canvas.translate(0,250);
        pathSourcePaint.getFillPath(pathS,path2);
        canvas.drawPath(pathS,pathSourcePaint);
        canvas.restore();

        pathPathPaint.setStyle(Paint.Style.STROKE);
        canvas.save();
        canvas.translate(400,250);
        canvas.drawPath(path2,pathPathPaint);
        canvas.restore();

        pathSourcePaint.setStyle(Paint.Style.STROKE);
        pathSourcePaint.setStrokeWidth(10);
        canvas.save();
        canvas.translate(0,500);
        pathSourcePaint.getFillPath(pathS,path3);
        canvas.drawPath(pathS,pathSourcePaint);
        canvas.restore();

        pathPathPaint.setStyle(Paint.Style.STROKE);
        canvas.save();
        canvas.translate(400,500);
        canvas.drawPath(path3,pathPathPaint);
        canvas.restore();

    }
}
