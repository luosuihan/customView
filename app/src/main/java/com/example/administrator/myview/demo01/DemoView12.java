package com.example.administrator.myview.demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myview.LogUtil;

/**
 * Created by Administrator on 2018/9/6.
 * 三阶贝塞尔曲线
 */

public class DemoView12 extends View {
    private Paint mPaint;
    private PointF start ,end ,control1,control2;
    private int centerX, centerY;
    public DemoView12(Context context) {
        super(context);
        init();
    }

    public DemoView12(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        start = new PointF(0,0);
        end = new PointF(0,0);
        control1 = new PointF(0,0);
        control2 = new PointF(0,0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w/2;
        centerY = h/2;
        LogUtil.e("centerX = "+centerX+"  ,centerY = "+centerY);
        start.x = centerX - 200;
        start.y = centerY;

        end.x = centerX + 200;
        end.y = centerY ;

        control1.x = centerX;
        control1.y = centerY + 300;

        control2.x = centerX + 300;
        control2.y = centerY + 300;



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (true){
            control1.x = event.getX();
            control1.y = event.getY();
        }else {
            control2.x = event.getX();
            control2.y = event.getY();
        }
        invalidate();
        return true;
//        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.translate(centerX,centerY);

        //绘制点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x,start.y,mPaint);
        canvas.drawPoint(end.x,end.y,mPaint);
        canvas.drawPoint(control1.x,control1.y,mPaint);
        canvas.drawPoint(control2.x,control2.y,mPaint);

        //绘制辅助线
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(3);
        /*(float startX, float startY, float stopX, float stopY, @NonNull Paint paint)*/
      //  canvas.drawLine(start.x,start.y,end.x,end.y,mPaint);
       /* canvas.drawLine(start.x,start.y,control1.x,control1.y,mPaint);
        canvas.drawLine(end.x,end.y,control1.x,control1.y,mPaint);*/

        canvas.drawLine(start.x, start.y, control1.x, control1.y, mPaint);
        canvas.drawLine(control1.x, control1.y,control2.x, control2.y, mPaint);
        canvas.drawLine(control2.x, control2.y,end.x, end.y, mPaint);

        //绘制曲线
        Path path = new Path();
        mPaint.setColor(Color.RED);
        path.moveTo(start.x,start.y);
        /*quadTo(float x1, float y1, float x2, float y2)*/
//        path.quadTo(control1.x,control1.y,end.x,end.y);
        path.cubicTo(control1.x, control1.y, control2.x,control2.y, end.x, end.y);
        canvas.drawPath(path,mPaint);
    }
}
