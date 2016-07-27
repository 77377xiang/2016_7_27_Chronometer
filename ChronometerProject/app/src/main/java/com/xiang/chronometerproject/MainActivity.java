package com.xiang.chronometerproject;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Button start;
    Chronometer test;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start= (Button) findViewById(R.id.start);
        test= (Chronometer) findViewById(R.id.test);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置开始的时间
                test.setBase(SystemClock.elapsedRealtime());
                test.start();
                start.setEnabled(false);
            }
        });
        //计时器的绑定监听
        test.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //设置起始时间到现在超过20秒停止
                if (SystemClock.elapsedRealtime()-chronometer.getBase()>20*1000) {
                    test.stop();
                    start.setEnabled(true);
                }

            }
        });

    }
}
