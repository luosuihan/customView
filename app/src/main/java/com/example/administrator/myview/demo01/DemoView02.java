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
 * 自定义ProgressBar
 */

public class DemoView02 extends View {
    private static final String TAG = DemoView02.class.getSimpleName();
    private Paint paint;
    private RectF rectF;
    private int width;
    private Paint paint1;
    private Paint textPaint;
    private int progress = 0;//当前进度值
    //最大的进度值
    private int max = 100;
    public DemoView02(Context context) {
        super(context);
        init();
    }

    public DemoView02(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView02(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);//设置边框宽度

        paint1 = new Paint();
        paint1 = paint;

        //设置字体画笔
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextAlign(Paint.Align.CENTER);//设置字体位置
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(30);//设置字体大小
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);*/
        width = getWidth();
        rectF = new RectF(width / 2 -100,width /2-100,width / 2 +100,width/2+100);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout:changed = "+ changed+",left = "+left+",top = "+top+",right = "+right+",bottom = "+bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        canvas.drawCircle(width /2,width /2,100,paint);
        //
        paint.setColor(Color.RED);
        canvas.drawArc(rectF,-90,(int)(progress * 1f / max * 360),false,paint);

        textPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText((int)((progress * 1f / max) * 100f)+"%",width / 2,width /2,textPaint);
    }
    public void startToProgress(){
        new Thread(){
            @Override
            public void run(){
                super.run();
                while (progress < max){
                    progress++;
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //刷新进度条
                    postInvalidate();
                }
                if (onProgressCompleteListener != null) {
                    onProgressCompleteListener.onFinish();
                }
            }
        }.start();
    }
    //2.创建接口对象
    OnProgressCompleteListener onProgressCompleteListener;
    public interface OnProgressCompleteListener{
        void onFinish();
    }
    public void setOnProgressCompleteListener(OnProgressCompleteListener onProgressCompleteListener){
        this.onProgressCompleteListener = onProgressCompleteListener;
    }
}
