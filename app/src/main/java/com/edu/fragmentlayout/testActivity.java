package com.edu.fragmentlayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URL;

public class testActivity extends AppCompatActivity {
    private TextView time,path,title;
    private ImageView img;
    private String picurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
       Bundle bundle = this.getIntent().getExtras();
       String datas_time = bundle.getString("time");
       String datas_path = bundle.getString("path");
       String datas_title = bundle.getString("title");
        String datas_img = bundle.getString("img");



        initView();
       time.setText(datas_time);
       path.setText(datas_path);
       title.setText(datas_title);
        Glide.with(this).load(datas_img).into(img);
    }

    private void initView() {
        time = findViewById(R.id.text_time);
        path = findViewById(R.id.text_path);
        title = findViewById(R.id.text_title);
        img = findViewById(R.id.text_img);



    }
}
