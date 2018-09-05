package com.example.administrator.myview.demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/9/5.
 */

public class DemoView09 extends View {

    private int width;
    private int height;
    private Paint mPaint;

    public DemoView09(Context context) {
        super(context);
        init();
    }

    public DemoView09(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
    }

    public void init(){
        // 创建画笔
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, height / 2);
        mPaint.setColor(Color.RED);
        canvas.drawPoint(0,0,mPaint);
        mPaint.setColor(Color.BLACK);
        Path path = new Path();
        path.lineTo(200, 200);
        path.lineTo(200,0);
        RectF rectF = new RectF(100,100,300,300);
        path.addArc(rectF,0,90);
        //path.close();
        canvas.drawPath(path, mPaint); // 绘制Path
    }
}
