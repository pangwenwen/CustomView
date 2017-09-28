package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by hua.pang on 2017/8/1.
 */

/**
 * 一张位图可以转化为5*4的矩阵，android 中通过一维数组表示，
 * {
 *     1,0,0,0,0，
 *     0,1,0,0,0，
 *     0,0,1,0,0，
 *     0,0,0,1,0
 * }
 * 通过如图3所示的运算可知，颜色矩阵M的第一行参数abcde决定了图像的红色成分，
 * 第二行参数fghij决定了图像的绿色成分，第三行参数klmno决定了图像的蓝色成分，
 * 第四行参数pqrst决定了图像的透明度，第五列参数ejot是颜色的偏移量
 *
 * 而图像的RGBA值则存储在一个5*1的颜色分量矩阵C中，由颜色分量矩阵C可以控制图像的颜色效果
 * {
 *     R,
 *     G,
 *     B,
 *     A,
 *     1
 * }
 * 要想改变一张图片的颜色效果，
 *    1. 只需要改变图像的颜色分量矩阵即可
 *    2. 改变颜色分量时可以通过修改第5列的颜色偏移量来实现
 *    3. 直接对颜色值乘以某一系数而达到改变颜色分量的目的
 *
 */
public class CustomImage extends ImageView {
    private Bitmap mBitmap;
    private ColorMatrix mColorMatrix;

    private Paint mPaint;
    private float[] mColorArray = {1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0};

    public CustomImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        mPaint = new Paint();
        canvas.drawBitmap(mBitmap,0,0,mPaint);
        mColorMatrix = new ColorMatrix();
        mColorMatrix.set(mColorArray);

        mPaint.setColorFilter(new ColorMatrixColorFilter(mColorMatrix));

        canvas.drawBitmap(mBitmap,0,0,mPaint);

    }

    public void setBitmap(Bitmap bitmap){
        mBitmap = bitmap;

        invalidate();
    }

    public void setmColorArray(float[] colorArray){
        this.mColorArray = colorArray;
        invalidate();
    }
}
