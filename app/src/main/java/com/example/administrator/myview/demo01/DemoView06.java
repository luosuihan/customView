package com.example.administrator.myview.demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/9/5.
 */

public class DemoView06 extends View {

    private Paint mPaint;
    private Paint mPaintDot;
    private Paint mPaintCircle;
    private Paint mPaintArc;
    private Paint mPaintArc1;
    int mleft;
    int mtop;
    int mright;
    int mbottom;

    public DemoView06(Context context) {
        super(context);
        initView();
    }

    public DemoView06(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public void initView(){
        //矩形 。。。
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GRAY);
        //点
        mPaintDot = new Paint();
        mPaintDot.setAntiAlias(true);
        mPaintDot.setStyle(Paint.Style.FILL);
        mPaintDot.setColor(Color.RED);
//        mPaintDot.setTextSize(40);
        mPaintDot.setStrokeWidth(30);
        //圆
        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStyle(Paint.Style.FILL);
        mPaintCircle.setColor(Color.BLACK);

        mPaintArc = new Paint();
        mPaintArc.setAntiAlias(true);
        mPaintArc.setStyle(Paint.Style.FILL);
        mPaintArc.setColor(Color.GREEN);

        mPaintArc1 = new Paint();
        mPaintArc1.setAntiAlias(true);
        mPaintArc1.setStyle(Paint.Style.FILL);
        mPaintArc1.setColor(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("luosuihan", "onLayout: changed = "+changed +"  left = "+left+ "top = "+ top + "right = "+right + " bottom = "+bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(100,100,600,600);
        canvas.drawRect(rectF,mPaint);
        canvas.drawCircle(350,350,250,mPaintCircle);
        canvas.drawPoint(350,350,mPaintDot);
        canvas.drawArc(rectF,0,90,true,mPaintArc);
        canvas.drawArc(rectF,90,60,true,mPaintArc1);
        canvas.translate();

    }
}
