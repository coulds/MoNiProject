package com.edu.fragmentlayout.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.edu.fragmentlayout.R;

public class GouWuche_itemActivity extends AppCompatActivity {

    private TextView title,pirce,total;
    private ImageView img;
    private String price_item,img_item,title_item,number_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wuche_item);

        initViews();
        Bundle bundle = this.getIntent().getExtras();
        price_item = bundle.getString("pid_info");
        img_item = bundle.getString("img_info");
        title_item = bundle.getString("total_info");
        number_item = bundle.getString("number_info");

        pirce.setText(price_item);
        title.setText(title_item);
        total.setText(number_item);
        Glide.with(this).load(img_item).into(img);

    }

    private void initViews() {
        img = findViewById(R.id.item_pic);
        title = findViewById(R.id.item_name);
        pirce = findViewById(R.id.item_price);
        total = findViewById(R.id.item_spec);
    }
}
