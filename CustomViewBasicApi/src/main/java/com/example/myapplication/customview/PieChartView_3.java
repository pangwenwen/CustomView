package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua.pang on 2017/9/1.
 *
 * 待解决的问题：比例大的饼图部分抽出来一部分
 */

public class PieChartView_3 extends View {
    private int mNum;
    private float[] mRatio = {0.2f,0.4f,0.1f,0.2f,0.1f};
    public PieChartView_3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNum(int num){
        mNum = num;
    }

    public void setRatios(float[] ratios){
        this.mRatio = ratios;
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#88551166"));
        float startAngle = 0;
        int num = mRatio.length;
        int strokR = 2 * num;
        int realR = 360 - strokR;

        float max = mRatio[0];
        int max_index = 0;
        for (int i = 0;i<num;i++){
            if (mRatio[i] > max){
                max = mRatio[i];
                max_index = i;
            }
        }


        for(int i = 0;i<num;i++){
            float ratio = mRatio[i]*realR;
            /*if (i == max_index){
                float centerR = startAngle+ratio*0.5f;
                float x = (float) Math.cos(centerR) * 50;
                float y = (float) Math.sin(centerR) * 50;
                canvas.save();
                canvas.translate(x,y);
                canvas.drawArc(200,100,600,500,startAngle,ratio,true,paint);
                canvas.restore();
            }else {*/
                canvas.drawArc(200,100,600,500,startAngle,ratio,true,paint);
            //}
            //startAngle += ratio+5;
            startAngle = startAngle + ratio + 2;
        }
    }
}
