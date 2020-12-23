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
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        Kawaii_LoadingView = findViewById(R.id.Kawaii_LoadingView);
        start();
        Animatordelaystart();
    }

    private void start() {
        Kawaii_LoadingView.startMoving();//启动动画
    }

    private void Animatordelaystart() {

        final Intent intent = new Intent(Loding.this, MainActivity.class);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask,1500);
    }

    @Override
    protected void onNewIntent(Intent intent) {

        if (intent != null) {
            // 是否退出App的标识
            boolean isExitApp = intent.getBooleanExtra("exit", false);
            if (isExitApp) {
                // 关闭自身
                this.finish();
            }
        }
        super.onNewIntent(intent);
    }

    @Override
    protected void onDestroy() {

        Kawaii_LoadingView.stopMoving();//当活动停止时 就结束动画 进行优化
        timer.cancel();
        super.onDestroy();
    }
}
