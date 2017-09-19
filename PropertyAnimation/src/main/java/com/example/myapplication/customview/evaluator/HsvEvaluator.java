package com.example.myapplication.customview.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by hua.pang on 2017/9/18.
 */

public class HsvEvaluator implements TypeEvaluator<Integer> {
    float[] startHsv = new float[3];
    float[] endtHsv = new float[3];
    float[] outtHsv = new float[3];


    @Override
    public Integer evaluate(float v, Integer start, Integer end) {
        Color.colorToHSV(start,startHsv);
        Color.colorToHSV(end,endtHsv);

        outtHsv[0] = startHsv[0]+(endtHsv[0] - startHsv[0])*v;
        outtHsv[1] = startHsv[1]+(endtHsv[1] - startHsv[1])*v;
        outtHsv[2] = startHsv[2]+(endtHsv[2] - startHsv[2])*v;

        int alph = (int)start>>24 + (int)((start>>24 - end>>24)*v);

        return Color.HSVToColor(alph,outtHsv);
    }
    /*float[] startHsv = new float[3];
    float[] endHsv = new float[3];
    float[] outHsv = new float[3];

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        // 把 ARGB 转换成 HSV
        Color.colorToHSV(startValue, startHsv);
        Color.colorToHSV(endValue, endHsv);

        // 计算当前动画完成度（fraction）所对应的颜色值
        if (endHsv[0] - startHsv[0] > 180) {
            endHsv[0] -= 360;
        } else if (endHsv[0] - startHsv[0] < -180) {
            endHsv[0] += 360;
        }
        outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
        if (outHsv[0] > 360) {
            outHsv[0] -= 360;
        } else if (outHsv[0] < 0) {
            outHsv[0] += 360;
        }
        outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
        outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

        // 计算当前动画完成度（fraction）所对应的透明度
        int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

        // 把 HSV 转换回 ARGB 返回
        return Color.HSVToColor(alpha, outHsv);
    }*/
}
