package com.example.myapplication.customview.tanslate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/13.
 */

public class TranslateXYZ_2 extends LinearLayout {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    Button btn;
    int click_count = 0;
    String[] texts = {"TranslateX","TranslateByX","TranslateY","TranslateZ","X"};

    public TranslateXYZ_2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img5.setOutlineProvider(new Outline());
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (click_count){
                    case 0:
                        img1.animate().translationX(100);
                        break;
                    case 1:
                        img2.animate().translationXBy(100);
                        break;
                    case 2:
                        img3.animate().translationY(100);
                        break;
                    case 3:
                        img4.animate().translationZ(100);
                        break;
                    case 4:
                        img5.animate().x(100);
                        break;
                }
                click_count = (++click_count)%5;
                btn.setText(texts[click_count]);
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public class Outline extends ViewOutlineProvider{
        @Override
        public void getOutline(View view, android.graphics.Outline outline) {
            int width = view.getWidth();
            int height = view.getHeight();
            int top = view.getTop();

            outline.setRect(0,top,0+width+100,top+height-50);

        }
    }
}
