package com.example.myapplication.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by hua.pang on 2017/8/30.
 * 可以描述直线、二次曲线、三次曲线、圆、椭圆、弧形、矩形、圆角矩形。把这些图形结合起来，就可以描述出很多复杂的图形
 */
public class PathUseView_2 extends View {
    private Context mContext;
    public PathUseView_2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#9911ff"));

        //一 addXXX 添加子图形,和直接画图类似，添加完整封闭的图形
        Path circlPath = new Path();
        circlPath.addCircle(100,100,50, Path.Direction.CW);//CW:顺时针；CCW逆时针
        paint.setStrokeWidth(5);
        canvas.drawPath(circlPath,paint);

        //二. XXXTo 画线
         //1. 直线lineTo 绝对位置；rLineTo 相对位置
        Path linPath = new Path();
        linPath.moveTo(200,10);
        linPath.lineTo(240,5);
        linPath.rLineTo(-10,70);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPath(linPath,paint);

        //2.贝塞尔曲线 http://www.html-js.com/article/1628
        Path bsrPath = new Path();
        bsrPath.moveTo(230,85);
        //------二阶
        bsrPath.quadTo(250,130,260,100);
        canvas.drawPath(bsrPath,paint);
        //------三阶
        bsrPath.moveTo(300,0);
        bsrPath.cubicTo(240,25,360,75,300,100);
        canvas.drawPath(bsrPath,paint);

        //3. 画弧
        Path arcPath = new Path();
        //paint.setStyle(Paint.Style.FILL_AND_STROKE);
        arcPath.addArc(400,0,500,200,-180,170);//forceMoveTo 默认为true的表现
        //canvas.drawPath(arcPath,paint);

        arcPath.arcTo(490,0,590,200,-170,170,false);//forceMoveTo:true 从上一个点直接移动到起始点，不留痕迹；否则会画出一条线
        //canvas.drawPath(arcPath,paint);

        arcPath.rLineTo(-95,80);
        paint.setStrokeCap(Paint.Cap.BUTT);
        arcPath.close();
        canvas.drawPath(arcPath,paint);

        //三、 辅助的设置或计算
        Path fillPath = new Path();
        Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //EVEN_ODD:(奇偶原则，奇涂偶不涂)对于平面中的任意一点，向任意方向射出一条射线，这条射线和图形相交的次数（相交才算，相切不算哦）如果是奇数，则这个点被认为在图形内部，是要被涂色的区域；如果是偶数，则这个点被认为在图形外部，是不被涂色的区域
        //WINDING:它需要你图形中的所有线条都是有绘制方向的，同样是从平面中的点向任意方向射出一条射线，但计算规则不一样：以 0 为初始值，对于射线和图形的所有交点，遇到每个顺时针的交点（图形从射线的左边向右穿过）把结果加 1，遇到每个逆时针的交点（图形从射线的右边向左穿过）把结果减 1，最终把所有的交点都算上，得到的结果如果不是 0，则认为这个点在图形内部，是要被涂色的区域；如果是 0，则认为这个点在图形外部，是不被涂色的区域
        //INVERSE_EVEN_ODD:与EVEN_ODD相反
        //INVERSE_WINDING:与WINDING相反
        //paint.setStrokeWidth(1);
        fillPath.setFillType(Path.FillType.WINDING);
        fillPath.addCircle(400,300,100, Path.Direction.CW);
        //fillPath.addCircle(500,300,100, Path.Direction.CCW);
        fillPath.addRect(300,200,500,350, Path.Direction.CCW);
        canvas.drawPath(fillPath,fillPaint);
    }
}
