package com.example.myapplication.customview.interpolator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/14.
 */

public class Animation_Interpolator_3 extends LinearLayout {
    Button btn1;
    ImageView img1;

    int click_count = 0;
    String[] strings = {"先加速后减速","线性","加速","减速","AnticipateInterpolator","OvershootInterpolator","AnticipateOvershootInterpolator","BounceInterpolator","CycleInterpolator"};

    public Animation_Interpolator_3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    ObjectAnimator obj1;

    @Override
    protected void onAttachedToWindow() {

        super.onAttachedToWindow();

        btn1 = findViewById(R.id.btn);
        img1 = findViewById(R.id.img1);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (click_count){
                    case 0:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new AccelerateDecelerateInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();

                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                               img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 1:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new LinearInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 2:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new AccelerateInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 3:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new DecelerateInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 4:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new AnticipateInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 5:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new OvershootInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 6:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new AnticipateOvershootInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 7:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        obj1.setInterpolator(new BounceInterpolator());
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    case 8:
                        obj1 = ObjectAnimator.ofFloat(img1,"translationX",0,400);
                        //效果与AccelerateDecelerateInterpolator类似，但是其可以自定义执行的周期,也会往相反的方向执行一次一样的动画
                        obj1.setInterpolator(new CycleInterpolator(1f));
                        obj1.setDuration(5000);
                        obj1.start();
                        obj1.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                img1.setTranslationX(0);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        break;
                    default:
                        break;
                }
                click_count = (++click_count)%9;
                btn1.setText(strings[click_count]);

            }
        });
    }
}
