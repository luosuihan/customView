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
 * Created by Administrator on 2018/9/4.
 * 圆形数据图绘制
 */

public class DemoView04 extends View {

    private Paint mPaint;
    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
   // private ArrayList<PieData> mData;
    // 宽高
    private int mWidth, mHeight;
    private Paint paintRed;
    private Paint paintGreen;

    public DemoView04(Context context) {
        super(context);
        init();
    }

    public DemoView04(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GRAY);
        paintRed = new Paint();
        paintRed.setStyle(Paint.Style.FILL);
        paintRed.setAntiAlias(true);
        paintRed.setColor(Color.RED);
        paintGreen = new Paint();
        paintGreen.setStyle(Paint.Style.FILL);
        paintGreen.setAntiAlias(true);
        paintGreen.setColor(Color.GREEN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.e("luosuihan", "onSizeChanged: mWidth = "+mWidth+"  ,mHeight = "+mHeight );
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float r = mWidth / 2;
        float r1 = mHeight / 2;
        Log.e("luosuihan", "onDraw: r = "+r+",r1 = "+r1);
        canvas.drawCircle(r,r1,200,mPaint);
        //左 上 右 下
        RectF rectF = new RectF(-688,-688,688,688);
        canvas.drawArc(rectF,0,60,true,paintGreen);
    }
}
