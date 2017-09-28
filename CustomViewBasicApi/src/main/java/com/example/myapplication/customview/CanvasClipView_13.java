package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/11.
 */

public class CanvasClipView_13 extends View {

    Bitmap bitmap;
    Paint mPaint;
    public CanvasClipView_13(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.xin);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawBitmap(bitmap,100,100,mPaint);

        //1. clip 裁剪的是画布，如果作画在裁剪的画布外，则不会显示
        canvas.save();
        canvas.clipRect(0,0,100,100);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.drawBitmap(bitmap,200,200,mPaint);//不会被绘制
        canvas.restore();

        canvas.save();
        Path path = new Path();
        path.addCircle(200,200,100, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,100,100,mPaint);
        canvas.restore();

        canvas.save();
        Path path1 = new Path();
        path1.setFillType(Path.FillType.INVERSE_WINDING);//会绘制出反向剪裁的效果
        path1.addCircle(200,500,200, Path.Direction.CW);
        canvas.clipPath(path1);
        canvas.drawBitmap(bitmap,0,300,mPaint);
        canvas.restore();
    }
}
