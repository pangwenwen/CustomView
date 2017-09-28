package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/9/4.
 */

public class PaintBitmapShaderView_4 extends View {
    private Context mContext;

    public PaintBitmapShaderView_4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.xin);
        BitmapShader bpShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.CLAMP);
        Paint shaderP = new Paint();
        shaderP.setShader(bpShader);
        //canvas.drawBitmap(bitmap,0,0,shaderP);
        canvas.drawCircle(350,350,350,shaderP);

    }
}
