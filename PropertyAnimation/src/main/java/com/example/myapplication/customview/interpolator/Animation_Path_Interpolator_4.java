package com.example.myapplication.customview.interpolator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/14.
 *
 * x:时间完成度； y:动画完成度
 */

public class Animation_Path_Interpolator_4 extends LinearLayout{
    ImageView img1;
    Button btn;
    int count = 0;
    String[] strings = {"1:1效果","自定义效果","circle 效果"};
    public Animation_Path_Interpolator_4(Context context, @Nullable AttributeSet attrs) {
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
                        Path path = new Path();
                        path.lineTo(1,1);
                        ObjectAnimator animator = ObjectAnimator.ofFloat(img1,"translationY",0,600);
                        PathInterpolator interpolator = new PathInterpolator(path);
                        animator.setInterpolator(interpolator);
                        animator.setDuration(3000);
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            /**
                             * 在调用cancel的时候也会被调用
                             * @param animator
                             */
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
                        animator.start();
                        break;
                    case 1:
                        Path path1 = new Path();
                        path1.lineTo(0.25f,0.25f);
                        path1.moveTo(0.25f,1.2f);
                        path1.lineTo(1f,1f);
                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img1,"translationY",0,600);
                        PathInterpolator interpolator1 = new PathInterpolator(path1);
                        animator1.setDuration(3000);
                        animator1.setInterpolator(interpolator1);
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

                }
                count = (++count)%2;
                btn.setText(strings[count]);

            }
        });

    }
}
