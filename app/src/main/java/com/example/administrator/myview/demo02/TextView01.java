package com.example.administrator.myview.demo02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/9/6.
 * 缩放，进场出场顺序,渐变
 */

public class TextView01 extends View {

    private Paint mPaint;
    private Paint mPaintLine;
    private float mRadius, mGapWidth;
    private float mPointX, mPointY, mFactor;
    private float mPointX1, mPointY1, mFactor1;
    private float mPointX2, mPointY2, mFactor2;
    private int mWidth, mHeight, mHeightNoLine, mLineWidth = 5;
    private static final float sAngle = (float) (Math.PI / 4);
    private long mDuration = 1000;

    private ValueAnimator mAnim, mAnim1, mAnim2;

    public TextView01(Context context) {
        super(context);
        initView();
    }

    public TextView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);

        mPaintLine = new Paint();
        mPaintLine.setAntiAlias(true);
        mPaintLine.setStyle(Paint.Style.FILL);
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStrokeWidth(mLineWidth);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mHeightNoLine = mHeight - mLineWidth;
        mRadius = (mHeight - mLineWidth) / 6f / 2f;
        mGapWidth = mRadius / 6f;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0,0,50,50);
       // canvas.translate(getWidth()/2,getHeight()/2);
//        canvas.drawCircle(100,100,80,mPaint);
        canvas.drawCircle(mPointX,mPointY,mRadius * mFactor,mPaint);
        canvas.drawCircle(mPointX1,mPointY1,mRadius * mFactor1,mPaint);
        canvas.drawCircle(mPointX2,mPointY2,mRadius * mFactor2,mPaint);
        if (mFactor > 0.5f) {
            canvas.drawLine(mPointX - (mFactor - 0.5f) * 3f * mRadius, mHeight, mPointX + (mFactor - 0.5f) * 3f * mRadius, mHeight, mPaintLine);
        }

        if (mFactor1 > 0.5f) {
            canvas.drawLine(mPointX1 - (mFactor1 - 0.5f) * 3f * mRadius, mHeight, mPointX1 + (mFactor1 - 0.5f) * 3f * mRadius, mHeight, mPaintLine);
        }

        if (mFactor2 > 0.5f) {
            canvas.drawLine(mPointX2 - (mFactor2 - 0.5f) * 3f * mRadius, mHeight, mPointX2 + (mFactor2 - 0.5f) * 3f * mRadius, mHeight, mPaintLine);
        }
    }

    public void  startLoadingAnimation(){
        LoadingEvaluator loadingEvaluator = new LoadingEvaluator(mWidth, mHeightNoLine, mRadius, mGapWidth);
        mAnim = ValueAnimator.ofObject(loadingEvaluator, new Point(0, 0, 0), new Point(0, mWidth, 0));

        mAnim.setDuration(mDuration);

        mAnim.setRepeatCount(Integer.MAX_VALUE);
        mAnim1=mAnim.clone();
        mAnim2=mAnim.clone();

        mAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mAnim1.setStartDelay(mDuration / 10);
                mAnim1.start();
            }
        });

        mAnim1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mAnim2.setStartDelay(mDuration / 20);
                mAnim2.start();
            }
        });


        mAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();

                mPointX = point.x;
                mPointY = point.y;
                mFactor = point.factor;
                invalidate();

            }
        });

        mAnim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();

                mPointX1 = point.x;
                mPointY1 = point.y;
                mFactor1 = point.factor;

            }
        });
        mAnim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                mPointX2 = point.x;
                mPointY2 = point.y;
                mFactor2 = point.factor;

            }
        });

        mAnim.start();
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mAnim!=null)
            mAnim.cancel();

        if(mAnim1!=null)
            mAnim1.cancel();

        if(mAnim2!=null)
            mAnim2.cancel();
    }

    static class Point implements Parcelable {
        public int x;
        public int y;
        public float factor;//半径所占全部半径的比例

        public Point() {
        }

        public Point(float factor, int x, int y) {
            this.factor = factor;
            this.x = x;
            this.y = y;
        }

        protected Point(Parcel in) {
            x = in.readInt();
            y = in.readInt();
            factor = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(x);
            dest.writeInt(y);
            dest.writeFloat(factor);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Point> CREATOR = new Creator<Point>() {
            @Override
            public Point createFromParcel(Parcel in) {
                return new Point(in);
            }

            @Override
            public Point[] newArray(int size) {
                return new Point[size];
            }
        };
    }

    static class LoadingEvaluator implements TypeEvaluator<Point> {

        private int mWidth, mHeight;
        private float mGapWidth, mRadius;

        public LoadingEvaluator(int width, int height, float radius, float gapWidth) {
            this.mWidth = width;
            this.mHeight = height;
            this.mGapWidth = gapWidth;
            this.mRadius = radius;
        }

        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            Path path = new Path();
            PathMeasure pathMeasure = new PathMeasure();
            path.moveTo(0, 0);

            float factor = 0, x = 0, y = 0;

            float changeModeX = (float) ((mHeight - mRadius) * Math.tan(sAngle));

            path.quadTo(changeModeX * 0.4f, 0, changeModeX, mHeight - mRadius);
            path.lineTo(mWidth - changeModeX, mHeight - mRadius);
            path.quadTo(mWidth - changeModeX, changeModeX * 0.6f, mWidth, 0);

            pathMeasure.setPath(path, false);

            float allDistance = pathMeasure.getLength();//所有的长度

            float circleDistance = (allDistance - (mWidth - 2 * changeModeX)) / 2;//一个圆弧的长度，也就是开始横着移动的点
            float circleDistanceAgain = allDistance - circleDistance;//另外一个圆弧的起始点

            float changeModeProportion = circleDistance / allDistance;
            float changeModeProportionAgain = circleDistanceAgain / allDistance;

            float changeDistance = (circleDistance - 3 * 2 * mRadius + 2 * mGapWidth);//计算三个圆加间隙剩下的大小，用来放大圆，到正常大小

            float moveDistance = fraction * allDistance;//当前移动的距离

            float[] positions = new float[2];
            pathMeasure.getPosTan(moveDistance, positions, null);

            if (fraction > changeModeProportion && fraction < changeModeProportionAgain) {
                factor = 1;
            } else if (fraction < changeModeProportion) {

                if (moveDistance < changeDistance) {
                    factor = moveDistance / changeDistance;
                } else {
                    factor = 1;
                }
            } else {
                if ((allDistance - moveDistance) > changeDistance) {
                    factor = 1;
                } else {
                    factor = (allDistance - moveDistance) / changeDistance;
                }
            }


            return new Point(factor, Math.round(positions[0]), Math.round(positions[1]));
        }
    }
}
