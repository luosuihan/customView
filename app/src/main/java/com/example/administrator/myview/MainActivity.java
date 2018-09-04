package com.example.administrator.myview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myview.demo01.DemoView02;

public class MainActivity extends AppCompatActivity implements DemoView02.OnProgressCompleteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoView02 viewById = (DemoView02) findViewById(R.id.mpb);
        viewById.startToProgress();
        //监听器
        viewById.setOnProgressCompleteListener(this);

    }

    @Override
    public void onFinish() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), "执行完毕", Toast.LENGTH_LONG).show();
            }
        });
    }
}
