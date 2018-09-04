package com.example.administrator.myview.demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/9/4.
 * 几何图形基本绘制
 */

public class DemoView03 extends View {

    private Paint paint;
    private RectF rectF;
    private Paint paintBlack;

    public DemoView03(Context context) {
        super(context);
        init();
    }

    public DemoView03(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView03(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
//    public RectF(float left, float top, float right, float bottom)
    public void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        paintBlack = new Paint();
        paintBlack.setStyle(Paint.Style.FILL);
        paintBlack.setAntiAlias(true);
        paintBlack.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawColor(Color.RED);
       // canvas.drawPoints(new float[]{200,300,200,400,200,500},paint);
// public void drawArc(@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint){}
        //    public RectF(float left, float top, float right, float bottom)
//        drawRoundRect(@NonNull RectF rect, float rx, float ry, @NonNull Paint paint)  ---- > rx与ry分别表示是圆心和半径
      /*  rectF = new RectF(100,100,600,300);
        canvas.drawRoundRect(rectF,300,130,paint);*/
        rectF = new RectF(-400,-400,400,400);

      //绘制圆形数据图
        canvas.drawCircle(400,400,300,paint);
        canvas.drawArc(rectF,0,90,true,paintBlack);
    }
}
