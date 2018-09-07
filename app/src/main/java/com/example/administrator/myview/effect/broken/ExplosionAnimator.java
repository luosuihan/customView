package com.example.administrator.myview.effect.broken;

import android.animation.ValueAnimator;

/**
 * Created by Administrator on 2018/9/7.
 */

public class ExplosionAnimator extends ValueAnimator {
    public static final int DEFAULT_DURATION = 1500;
    public ExplosionAnimator(){
        setFloatValues(0.0f,1.0f);
        setDuration(DEFAULT_DURATION);
    }
}
