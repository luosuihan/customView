package com.example.administrator.myview.demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.myview.LogUtil;

/**
 * Created by Administrator on 2018/9/5.
 * 蜘蛛网绘制
 * 1，先绘制六边形
 */

public class DemoView10 extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Paint mPaintHexagon;//规则六边形
    private Paint mHexagonAnomaly;//不规则六边形

    public DemoView10(Context context) {
        super(context);
        initView();
    }

    public DemoView10(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(30);
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);

        mPaintHexagon = new Paint();
        mPaintHexagon.setColor(Color.BLACK);
        mPaintHexagon.setAntiAlias(true);
        mPaintHexagon.setStrokeWidth(20);
        mPaintHexagon.setStyle(Paint.Style.STROKE);

        mHexagonAnomaly = new Paint();
        mHexagonAnomaly.setColor(Color.GREEN);
        mHexagonAnomaly.setAntiAlias(true);
        mHexagonAnomaly.setStrokeWidth(10);
        mHexagonAnomaly.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtil.e("onMeasure()");
        mWidth = getWidth();
        mHeight = getHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        LogUtil.e("onLayout()");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = mWidth / 2;
        int h = mHeight / 2;
        canvas.translate(w,h);
        canvas.drawPoint(0,0,mPaint); //中心点

        //a点
        canvas.drawPoint(150,250,mPaintHexagon);
        //b点
        canvas.drawPoint(300,0,mPaintHexagon);
        //c点
        canvas.drawPoint(150,-250,mPaintHexagon);
        //d点
        canvas.drawPoint(-150,-250,mPaintHexagon);
        //e点
        canvas.drawPoint(-300,0,mPaintHexagon);
        //f点
        canvas.drawPoint(-150,250,mPaintHexagon);

        //画线
        Path path = new Path();
       /* path.lineTo(150,250); //a  3
        path.lineTo(300,0); //b  2
        path.lineTo(150,-250); //c 1
        path.lineTo(-150,-250);//d  6
        path.lineTo(-300,0);//e  5
        path.lineTo(-150,250);//f  4*/

       /* new*/

       /* path.lineTo(150,-250);
        path.lineTo(150,250);
        path.lineTo(-150,-250);
        path.lineTo(-150,250);*/

        path.moveTo(150,-250);
       // path.lineTo(150,-250);
        path.lineTo(-150,-250);
        path.lineTo(-300,0);
        path.lineTo(-150,250);
        path.lineTo(150,250);
        path.lineTo(300,0);
        path.lineTo(150,-250);

        canvas.drawPath(path,mPaintHexagon);

        //不规则六边形
       /* A点 ： 300,0；
        B点 ： 100,100；
        C点 ： -100，-300；
        D点 ： -200 ，0；
        E点： -150,250；
        F点： 150,250；*/

        // path.lineTo(150,-250);
      /*  Path path1 = new Path();
        path1.lineTo(300,0);
        path1.lineTo(100,-100);
        canvas.drawPoint(100,-100,mPaintHexagon);
        path1.lineTo(0,-150);
        canvas.drawPoint(0,-150,mPaintHexagon);
        path1.lineTo(-200,-150);
        canvas.drawPoint(-300,-100,mPaintHexagon);
        path1.lineTo(-200,0);

        canvas.drawPath(path1,mHexagonAnomaly);*/

    }
}
