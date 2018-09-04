package com.example.administrator.myview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myview.demo01.DemoView02;
import com.example.administrator.myview.demo01.DemoView05;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoView05 ringView = (DemoView05) findViewById(R.id.ringView);

        // 添加的是颜色
        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.color_ff3e60);
        colorList.add(R.color.color_ffa200);
        colorList.add(R.color.color_31cc64);
        colorList.add(R.color.color_3377ff);

        //  添加的是百分比
        List<Float> rateList = new ArrayList<>();
        rateList.add(10f);
        rateList.add(5f);
        rateList.add(45f);
        rateList.add(40f);
        ringView.setShow(colorList, rateList,false,true);
    }
}
