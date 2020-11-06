package com.edu.fragmentlayout.Activity;

import android.annotation.SuppressLint;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.edu.fragmentlayout.Fragment.ContacksFragment;
import com.edu.fragmentlayout.Fragment.MessageFragment;
import com.edu.fragmentlayout.Fragment.NewFragment;
import com.edu.fragmentlayout.R;
import com.edu.fragmentlayout.Fragment.SetFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="MainActivity" ;


    private MessageFragment messageFragment;
    private NewFragment newFragment;
    private SetFragment setFragment;
    private ContacksFragment contacksFragment;

//    private View newlayout;
//    private View setlayout;
//    private View contactslayout;
//    private View messagelayout;

   private RelativeLayout contactslayout;
   private RelativeLayout messagelayout;
   private RelativeLayout setlayout;
   private RelativeLayout newlayout;


    private android.app.FragmentManager manager;
    private FragmentTransaction ft;

    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView newsImage;
    private ImageView settingImage;
    private TextView messageText;
    private TextView contactsText;
    private TextView newsText;
    private TextView settingText;



    private FragmentManager fragmentManager;
    private ContacksFragment contacksFragment1 = new ContacksFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();

        fragmentManager  = getSupportFragmentManager();
        setTabSelection(0);
        getSupportFragmentManager();
    }


    private void initview() {


        messagelayout = findViewById(R.id.message_layout);
        contactslayout = findViewById(R.id.contacts_layout);
        newlayout = findViewById(R.id.news_layout);
        setlayout = findViewById(R.id.setting_layout);

        messageImage = (ImageView) findViewById(R.id.message_image);
        contactsImage = (ImageView) findViewById(R.id.contacts_image);
        newsImage = (ImageView) findViewById(R.id.news_image);
        settingImage = (ImageView) findViewById(R.id.setting_image);

        messageText = (TextView) findViewById(R.id.message_text);
        contactsText = (TextView) findViewById(R.id.contacts_text);
        newsText = (TextView) findViewById(R.id.news_text);
        settingText = (TextView) findViewById(R.id.setting_text);

        messagelayout.setOnClickListener(this);
        contactslayout.setOnClickListener(this);
        newlayout.setOnClickListener(this);
        setlayout.setOnClickListener(this);



//        caidan.setOnClickListener(this);

    }
    public void seleted() {
        messageImage.setSelected(false);
        contactsImage.setSelected(false);
        newsImage.setSelected(false);
        settingImage.setSelected(false);

        messageText.setSelected(false);
        contactsText.setSelected(false);
        newsText.setSelected(false);
        settingText.setSelected(false);
    }


    @SuppressLint("ResourceType")
    public void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (index){
            case 0:
                seleted();
                messageImage.setSelected(true);//message是咖啡
                messageText.setSelected(true);
                if (messageFragment == null){
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content,messageFragment);
                }else {
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                seleted();
                contactsImage.setSelected(true);//contact是饮料
                contactsText.setSelected(true);
                if (newFragment == null){
                    newFragment = new NewFragment();
                    transaction.add(R.id.content,newFragment);
                }else {
                    transaction.show(newFragment);
                }
                break;
            case 2:
                seleted();
                newsImage.setSelected(true);//new是啤酒
                newsText.setSelected(true);
                if (setFragment == null){
                    setFragment = new SetFragment();
                    transaction.add(R.id.content,setFragment);

                }else {
                    transaction.show(setFragment);
                }
                break;
            case 3:
                seleted();
                settingImage.setSelected(true);//setting是我的
                settingText.setSelected(true);
                if (contacksFragment == null){
                    contacksFragment = new ContacksFragment();
                    transaction.add(R.id.content,contacksFragment);

                }else {
                    transaction.show(contacksFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contacksFragment != null) {
            transaction.hide(contacksFragment);
        }
        if (newFragment != null) {
            transaction.hide(newFragment);
        }
        if (setFragment != null) {
            transaction.hide(setFragment);
        }

    }


    @Override
    public void onClick(View v) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);

        switch (v.getId()) {

            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;





            default:
                break;
        }

    }

}
