package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/11.
 */

public class CanvasMatrixView_15 extends View {
    Bitmap bitmap;
    Paint mPaint;
    public CanvasMatrixView_15(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.xin_tou);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1. 普通的变换,可以自定义普通变换的前后位置,
        /*
        Canvas.setMatrix(matrix)：用 Matrix 直接替换 Canvas 当前的变换矩阵，即抛弃 Canvas 当前的变换，改用 Matrix 的变换（注：根据下面评论里以及我在微信公众号中收到的反馈，不同的系统中  setMatrix(matrix) 的行为可能不一致，所以还是尽量用 concat(matrix) 吧）；
        Canvas.concat(matrix)：用 Canvas 当前的变换矩阵和 Matrix 相乘，即基于 Canvas 当前的变换，叠加上 Matrix 中的变换。
         */
        Matrix matrix = new Matrix();
        matrix.preRotate(45);
        matrix.postTranslate(100,0);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();

        //2. 自定义变换
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Matrix matrix1 = new Matrix();
        float[] srcP = {0,0,width,0,0,height,width,height};
        float[] desP = {0+40,0+10,width+100,0-100,height-30,0+100,width+200,height-40};
        matrix1.setPolyToPoly(srcP,0,desP,0,4);

        canvas.save();
        canvas.concat(matrix1);
        canvas.drawBitmap(bitmap,0,300,mPaint);
        canvas.restore();
    }
}
