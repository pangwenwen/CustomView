package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/11.
 */

public class CanvasCamera_16 extends View {
    Bitmap bitmap;
    Paint mPaint;

    public CanvasCamera_16(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.xin_tou);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //1. 基本方法
        Camera camera = new Camera();

        canvas.save();
        camera.save();
        camera.rotateX(45);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateY(45);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap,0,300,mPaint);
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateZ(45);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap,0,600,mPaint);
        canvas.restore();

        //2. 要使变换后的左右对称，要移到中心再变换
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        canvas.save();
        camera.save();
        camera.rotateX(45);
        canvas.translate(width/2+300,height/2);//注意顺序
        camera.applyToCanvas(canvas);
        canvas.translate(-width/2-300,-height/2);//注意顺序
        camera.restore();
        canvas.drawBitmap(bitmap,300,0,mPaint);
        canvas.restore();

        //3. 相机的移动,x:坐正又负；y:上负下正；z:里正外负；旋转，调整为正方向冲屏幕外，x,y均为顺时针，z为逆时针
        //在 Camera 中，相机的默认位置是 (0, 0, -8)（英寸）。8 x 72 = 576，所以它的默认位置是 (0, 0, -576)（像素）
        canvas.save();
        camera.save();
        camera.setLocation(0,0,-15);
        camera.rotateX(45);
        canvas.translate(width/2+300,height/2+600);//注意顺序
        camera.applyToCanvas(canvas);
        canvas.translate(-width/2-300,-height/2-600);//注意顺序
        camera.restore();
        canvas.drawBitmap(bitmap,300,400,mPaint);
        canvas.restore();
    }
}
