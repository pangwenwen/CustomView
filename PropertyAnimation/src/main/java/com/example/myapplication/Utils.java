package com.example.myapplication;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by hua.pang on 2017/9/13.
 */

public class Utils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}
