package com.example.myapplication.customview.evaluator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/18.
 */

public class EvaluatorLayout extends LinearLayout {

    Button btn;
    Evaluator1 evaluator1;

    Button btn2;
    Evaluator1 evaluator2;
    public EvaluatorLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    Button btn3;
    Evaluator1 evaluator3;
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btn = findViewById(R.id.btn);
        evaluator1 = findViewById(R.id.evaluator1);

        btn2 = findViewById(R.id.btn2);
        evaluator2 = findViewById(R.id.evaluator2);

        btn3 = findViewById(R.id.btn3);
        evaluator3 = findViewById(R.id.evaluator3);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofInt(evaluator1,"color",0xffff0000,0xff00ff00);
                //api 21以后可以使用ObjectAnimator.ofArgb()
                objectAnimator1.setDuration(3000);
                objectAnimator1.setEvaluator(new ArgbEvaluator());
                objectAnimator1.start();
            }
        });


        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofInt(evaluator2,"color",0xffff0000,0xff00ff00);
                //api 21以后可以使用ObjectAnimator.ofArgb()
                objectAnimator2.setDuration(3000);
                objectAnimator2.setEvaluator(new HsvEvaluator());
                objectAnimator2.start();
            }
        });

        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofObject(evaluator3,"position",new PointEvaluator(),new PointF(0,0),new PointF(1,1));
                //api 21以后已经有了 objectAnimator.setEvaluator(new PointFEvaluator());
                objectAnimator.setDuration(3000);
                objectAnimator.start();
            }
        });


    }
}
