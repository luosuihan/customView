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
 * Created by Administrator on 2018/9/3.
 *
 * (1) UPSPECIFIED :父容器对于子容器没有任何限制,子容器想要多大就多大.

 (2) EXACTLY父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间.

 (3) AT_MOST子容器可以是声明大小内的任意大小.
 */

public class DemoView01 extends View {
    private static final String TAG = DemoView01.class.getSimpleName();
    private Paint paint;
    private RectF rectF;

    public DemoView01(Context context) {
        super(context);
        init();
    }

    public DemoView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        rectF = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure: widthMode = "+widthMode );
        switch (widthMode){
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.UNSPECIFIED:
                break;

        }
        Log.e(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.e(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.e(TAG, "onMeasure--heightSize-->" + heightsize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: " );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        int with = getWidth();
        int height = getHeight();
        Log.e(TAG, "onDraw---->" + with + "*" + height);
        float radius = with / 4;
        canvas.drawCircle(with / 2,with /2,radius,paint);
        paint.setColor(Color.BLUE);
        rectF.set(with / 2 -radius,with / 2 - radius,with / 2 + radius,with / 2 +radius);
        canvas.drawArc(rectF,270,120,true,paint);
    }
}
