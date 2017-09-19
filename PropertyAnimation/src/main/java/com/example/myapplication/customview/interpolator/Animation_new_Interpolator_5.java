package com.example.myapplication.customview.interpolator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/18.
 */

public class Animation_new_Interpolator_5 extends LinearLayout {
    private String[] mStrings = {"FastOutLinearInInterpolator","FastOutSlowInInterpolator","LinearOutSlowInInterpolator"};
    ImageView img1;
    Button btn;
    int count = 0;

    public Animation_new_Interpolator_5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        img1 = findViewById(R.id.img1);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count){
                    case 0:
                        //它和  AccelerateInterpolator 一样，都是一个持续加速的运动路线。只不过 FastOutLinearInInterpolator 的曲线公式是用的贝塞尔曲线，
                        // 而 AccelerateInterpolator 用的是指数曲线。具体来说，它俩最主要的区别是
                        // FastOutLinearInInterpolator 的初始阶段加速度比 AccelerateInterpolator 要快一些。
                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img1,"translationY",0,600);
                        animator1.setInterpolator(new FastOutLinearInInterpolator());
                        animator1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationY(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        animator1.start();
                        break;
                    case 1:
                        //同样也是先加速再减速的还有前面说过的 AccelerateDecelerateInterpolator，不过它们的效果是明显不一样的。
                        // FastOutSlowInInterpolator 用的是贝塞尔曲线，AccelerateDecelerateInterpolator 用的是正弦 / 余弦曲线。具体来讲，
                        // FastOutSlowInInterpolator 的前期加速度要快得多。
                        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img1,"translationY",0,600);
                        animator2.setInterpolator(new FastOutSlowInInterpolator());
                        animator2.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationY(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        animator2.start();
                        break;
                    case 2:
                        //它和 DecelerateInterpolator 比起来，同为减速曲线，主要区别在于 LinearOutSlowInInterpolator 的初始速度更高。
                        // 对于人眼的实际感觉，区别其实也不大，不过还是能看出来一些的
                        ObjectAnimator animator3 = ObjectAnimator.ofFloat(img1,"translationY",0,600);
                        animator3.setInterpolator(new LinearOutSlowInInterpolator());
                        animator3.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationY(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        animator3.start();
                        break;
                }
                count = count++ % 3;
                btn.setText(mStrings[count]);
            }
        });
    }
}
