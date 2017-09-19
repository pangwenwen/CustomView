package com.example.myapplication.customview.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by hua.pang on 2017/9/18.
 */

public class PointEvaluator implements TypeEvaluator<PointF> {
    PointF pointF = new PointF();
    @Override
    public PointF evaluate(float v, PointF pointF, PointF t1) {
        float x = pointF.x+(t1.x - pointF.x)*v;
        float y = pointF.y+(t1.y - pointF.y)*v;
        pointF.set(x,y);
        return pointF;
    }
}
