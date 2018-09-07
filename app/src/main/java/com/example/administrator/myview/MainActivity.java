package com.example.administrator.myview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.example.administrator.myview.demo02.TextView01;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView01 viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = (TextView01) findViewById(R.id.ringView);
        viewById.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewById.startLoadingAnimation();
            }
        },10000);
    }

    @Override
    protected void onResume() {
        super.onResume();
       /* TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 1,
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 1);
        translateAnimation.setDuration(10000); // 持续时间
        viewById.startAnimation(translateAnimation);*/
    }
}
