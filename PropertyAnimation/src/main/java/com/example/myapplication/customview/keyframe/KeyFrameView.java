package com.example.myapplication.customview.keyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/19.
 */

public class KeyFrameView extends LinearLayout {

    Button btn;
    ProgressView progressView;
    public KeyFrameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btn = findViewById(R.id.btn);
        progressView = findViewById(R.id.progress);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Keyframe 拆分一个属性的执行过程
                Keyframe keyframe1 = Keyframe.ofInt(0,0);
                Keyframe keyframe2 = Keyframe.ofInt(0.6f,100);
                Keyframe keyframe3 = Keyframe.ofInt(1,80);

                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("progress",keyframe1,keyframe2,keyframe3);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(progressView,propertyValuesHolder);
                objectAnimator.setDuration(3000);
                objectAnimator.start();
            }
        });




    }
}
