package com.edu.fragmentlayout.Animator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edu.fragmentlayout.Activity.MainActivity;
import com.edu.fragmentlayout.R;

import java.util.Timer;
import java.util.TimerTask;

public class Loding extends AppCompatActivity {
    private Kawaii_LoadingView Kawaii_LoadingView;
    private View Loading ;
    private Button buttonStart,buttonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        Kawaii_LoadingView = findViewById(R.id.Kawaii_LoadingView);
//        buttonStart = (Button)findViewById(R.id.start);
//        buttonFinish = (Button)findViewById(R.id.finish);
//
//        buttonStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Kawaii_LoadingView.startMoving();
////                Loading.setVisibility(View.VISIBLE);
//            }
//
//        });
//
//        buttonFinish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Kawaii_LoadingView.stopMoving();
////                Loading.setVisibility(View.INVISIBLE);
//            }
//
//        });
        start();
        Animatordelaystart();
    }

    private void start() {
        Kawaii_LoadingView.startMoving();//启动动画
    }

    private void Animatordelaystart() {

        final Intent intent = new Intent(Loding.this, MainActivity.class);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };
        timer.schedule(timerTask,3*1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Kawaii_LoadingView.stopMoving();//当活动停止时 就结束动画 进行优化

    }
}
