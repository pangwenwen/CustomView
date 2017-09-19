package com.example.myapplication.customview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/19.
 * PropertyValuesHolder :多个属性同时执行
 */

public class PropertyValuesHolderView extends LinearLayout {
    Button btn;
    ImageView imageView1;
    ImageView imageView2;

    public PropertyValuesHolderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btn = findViewById(R.id.btn);
        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.animate().setDuration(3000).alpha(1).scaleX(1).scaleY(1);
                PropertyValuesHolder alphHolder = PropertyValuesHolder.ofFloat("alpha",1);
                PropertyValuesHolder xHolder = PropertyValuesHolder.ofFloat("scaleX",1);
                PropertyValuesHolder yHolder = PropertyValuesHolder.ofFloat("scaleY",1);

                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView2,alphHolder,xHolder,yHolder);
                objectAnimator.setDuration(3000);
                objectAnimator.start();
            }
        });
    }
}
