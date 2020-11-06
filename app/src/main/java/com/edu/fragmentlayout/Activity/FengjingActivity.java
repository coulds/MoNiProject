package com.edu.fragmentlayout.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.edu.fragmentlayout.BeanClass.DataBean;
import com.edu.fragmentlayout.R;

public class FengjingActivity extends AppCompatActivity {
    private TextView pic_time,pic_pid,pic_cid,pic_total;
    private ImageView pic_img;
    private Button button_back,button_gwc;
    private String time,pid,cid,total,img;
    DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fengjing);
        initview();
        Bundle bundle = this.getIntent().getExtras();
        data = (DataBean)bundle.getSerializable("data");
        time = data.getC_t();
         pid = data.getPid();
         cid= data.getCid();
         total = data.getFav_total();
         img = data.getUrl();

        pic_time.setText(time);
        pic_pid.setText(pid);
        pic_cid.setText(cid);
        pic_total.setText(total);
        Glide.with(this).load(img).into(pic_img);


    }

    private void initview() {
        pic_time = findViewById(R.id.pic_time);
        pic_cid = findViewById(R.id.pic_cid);
        pic_pid= findViewById(R.id.pic_pid);
        pic_img = findViewById(R.id.pic_img);
        pic_total = findViewById(R.id.pic_total);
        button_gwc = findViewById(R.id.gouwuche);
        button_back = findViewById(R.id.pic_back);

        //返回的点击返回列表的点击事件
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //加入购物车的点击事件
        button_gwc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppApplication.setDataBeanList(data);
                Intent intent = new Intent(FengjingActivity.this,GouWuCheActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("dataTo",data);
//                bundle.putString("pid_info",pid);
//                bundle.putString("total_info",total);
//                bundle.putString("img_info",img);
//                bundle.putString("number_info",cid);
//                intent.putExtras(bundle);
                Toast.makeText(FengjingActivity.this,"商品添加成功",Toast.LENGTH_SHORT).show();
//                startActivity(intent);

            }
        });

    }


}
