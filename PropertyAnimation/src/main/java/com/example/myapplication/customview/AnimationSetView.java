package com.example.myapplication.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/19.
 */

public class AnimationSetView extends LinearLayout {
    Button btn;
    ImageView img;
    public AnimationSetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);


        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(img,"scaleX",1).setDuration(3000);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(img,"scaleY",1).setDuration(3000);

                ObjectAnimator alphA = ObjectAnimator.ofFloat(img,"alpha",1).setDuration(2000);

                ObjectAnimator translateX = ObjectAnimator.ofFloat(img,"translationX",300).setDuration(3000);

                ObjectAnimator translateY = ObjectAnimator.ofFloat(img,"translationY",300).setDuration(2000);

                AnimatorSet set = new AnimatorSet();

                //playTogether 一同执行
                set.playTogether(scaleX,scaleY,alphA);

                //playSequentially 依次执行
                set.playSequentially(alphA,translateX);

                //before after width 控制播放次序
                set.play(translateX).before(translateY);

                set.start();

            }
        });


    }
}
