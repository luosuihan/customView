package com.example.administrator.myview.demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.myview.LogUtil;

/**
 * Created by Administrator on 2018/9/5.
 */

public class DemoView08 extends View {

    private Paint mPaint;
    private int width;
    private int height;

    public DemoView08(Context context) {
        super(context);
        init();
    }

    public DemoView08(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = width / 2;
        int h = height / 2;
        LogUtil.e("w = "+w+"  ,h = "+h);
        canvas.translate(w,h);
       // canvas.drawCircle(0,0,100,mPaint);

//        mPaint.setColor(Color.GREEN);
//        mPaint.setStrokeWidth(20);
//        canvas.drawPoint(w,w,mPaint);
        RectF rectF = new RectF(-100,-100,100,100);
        mPaint.setColor(Color.BLACK);
//        mPaint.setStrokeWidth(10);
        canvas.drawRect(rectF,mPaint);
        //点
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(0,0,mPaint);
    }
}
