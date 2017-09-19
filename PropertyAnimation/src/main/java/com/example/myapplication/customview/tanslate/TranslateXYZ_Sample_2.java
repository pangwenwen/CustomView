package com.example.myapplication.customview.tanslate;

import android.view.View;

/**
 * Created by hua.pang on 2017/9/13.
 */

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example.myapplication.R;
import com.example.myapplication.Utils;

import static android.os.Build.VERSION.SDK_INT;

public class TranslateXYZ_Sample_2 extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    int translationStateCount = SDK_INT > Build.VERSION_CODES.LOLLIPOP ? 6 : 4;
    int translationState = 0;

    public TranslateXYZ_Sample_2(Context context) {
        super(context);
    }

    public TranslateXYZ_Sample_2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslateXYZ_Sample_2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(Utils.dpToPixel(100));
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        break;
                    case 2:
                        imageView.animate().translationY(Utils.dpToPixel(50));
                        break;
                    case 3:
                        imageView.animate().translationY(0);
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(Utils.dpToPixel(15));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(0);
                        }
                        break;
                }
                translationState++;
                if (translationState == translationStateCount) {
                    translationState = 0;
                }
            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, Utils.dpToPixel(10));
            path.lineTo(Utils.dpToPixel(7), Utils.dpToPixel(2));
            path.lineTo(Utils.dpToPixel(116), Utils.dpToPixel(58));
            path.lineTo(Utils.dpToPixel(116), Utils.dpToPixel(70));
            path.lineTo(Utils.dpToPixel(7), Utils.dpToPixel(128));
            path.lineTo(0, Utils.dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}
