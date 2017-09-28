package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/4.
 *
 * 绘制是在onDraw中执行的，要想执行onDraw必须执行invalidate 或者其他触发ondraw的方法
 *
 */

public class PaintComposeShader_5 extends View {
    private static final String TAG = "PaintComposeShader_5";
    private Context mContext;
    Paint dstAtopP ;
    Paint textPaint ;
    BitmapShader srcShader;
    BitmapShader desShader;
    int num = 0;

    PorterDuff.Mode[] modeArray = {PorterDuff.Mode.SRC,PorterDuff.Mode.SRC_OVER,PorterDuff.Mode.SRC_IN,PorterDuff.Mode.SRC_ATOP,PorterDuff.Mode.SRC_OUT
            ,PorterDuff.Mode.DST,PorterDuff.Mode.DST_OVER,PorterDuff.Mode.DST_IN,PorterDuff.Mode.DST_ATOP,PorterDuff.Mode.DST_OUT,PorterDuff.Mode.XOR,PorterDuff.Mode.CLEAR};


    public PaintComposeShader_5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        init();
    }
    private void init(){
        dstAtopP = new Paint();
        textPaint = new Paint();
        textPaint.setTextSize(24);
        textPaint.setAntiAlias(true);

        Bitmap srcBp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.batman_logo);
        Bitmap desBp = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.batman);

        srcShader = new BitmapShader(srcBp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        desShader = new BitmapShader(desBp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

    }
    private void drawD(Canvas canvas, PorterDuff.Mode mode){
        Log.e(TAG, "drawD: thread = "+Thread.currentThread() );
        //清空屏幕
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        //Log.e("pangwenwen",mode.toString());
        ComposeShader comShader = new ComposeShader(srcShader,desShader, mode);
        dstAtopP.setShader(comShader);
        canvas.drawRect(50,100,650,600,dstAtopP);
        canvas.drawText(mode.toString(),300,650,textPaint);
    }

    class MyHandler  extends Handler{
        Canvas canvas;
        public MyHandler(Canvas canvas) {
            this.canvas = canvas;
        }
        @Override
        public void handleMessage(Message msg) {
            invalidate();
        }
    }
    private MyHandler myHandler;

    class MyRunnable implements Runnable{
        @Override
        public void run() {
            isRunning = true;
            while (true){
                myHandler.sendEmptyMessage(1);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    private boolean isRunning = false;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "panghua onDraw: num = "+num);
        drawD(canvas,modeArray[(num++) % modeArray.length]);
        myHandler = new MyHandler(canvas);

        if (!isRunning){
            MyRunnable runnable = new MyRunnable();
            new Thread(runnable).start();
        }
    }
}
