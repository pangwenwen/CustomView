package com.example.myapplication.customview.spring;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.myapplication.R;
/**
 * Created by hua.pang on 2017/9/22.
 */

public class SpringView1 extends LinearLayout {
    ImageView img;
    Button btn;

    public SpringView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        img = findViewById(R.id.img);
        btn = findViewById(R.id.spring);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Path path = new Path();
                path.lineTo(0.2f,2);
                path.lineTo(0.4f,0.7f);
                path.lineTo(0.6f,1.2f);
                path.lineTo(0.8f,0.9f);
                path.lineTo(1f,1f);

                PathInterpolator pathInterpolator = new PathInterpolator(path);
                ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(img,"scaleX",1f,2f);
                objectAnimatorX.setInterpolator(pathInterpolator);
                ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(img,"scaleY",1f,2f);
                objectAnimatorY.setInterpolator(pathInterpolator);

                AnimatorSet set = new AnimatorSet();
                set.play(objectAnimatorX).with(objectAnimatorY);
                set.start();
            }
        });

    }


}
