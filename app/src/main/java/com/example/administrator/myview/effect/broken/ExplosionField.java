package com.example.administrator.myview.effect.broken;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/9/7.
 */

public class ExplosionField extends View {
    public ExplosionField(Context context) {
        super(context);
        initView();
    }

    public ExplosionField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制粒子集的画布
    }
    private static final Canvas mCanvas = new Canvas();
    private Bitmap createBitmapFromView(View view){

        Bitmap bitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
        if(bitmap != null){
            synchronized (mCanvas){
                mCanvas.setBitmap(bitmap);
                view.draw(mCanvas);
                mCanvas.setBitmap(null);
            }
        }

        return bitmap;
    }
}
