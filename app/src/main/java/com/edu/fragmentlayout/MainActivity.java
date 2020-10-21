package com.edu.fragmentlayout;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView menu;

    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout mdrawerLayout;
    private MessageFragment messageFragment;
    private NewFragment newFragment;
    private SetFragment setFragment;
    private ContacksFragment contacksFragment;
    private View messagelayout;
    private View newlayout;
    private View setlayout;
    private View contactslayout;
    private ImageView messageImage;
    private android.app.FragmentManager manager;
    private FragmentTransaction ft;




    /**
     * 在Tab布局上显示联系人图标的控件
     */
    private ImageView contactsImage;

    /**
     * 在Tab布局上显示动态图标的控件
     */
    private ImageView newsImage;

    /**
     * 在Tab布局上显示设置图标的控件
     */
    private ImageView settingImage;

    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView messageText;

    /**
     * 在Tab布局上显示联系人标题的控件
     */
    private TextView contactsText;

    /**
     * 在Tab布局上显示动态标题的控件
     */
    private TextView newsText;

    /**
     * 在Tab布局上显示设置标题的控件
     */
    private TextView settingText;

    private FragmentManager fragmentManager;
    private ContacksFragment contacksFragment1 = new ContacksFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initview();
        fragmentManager  = getSupportFragmentManager();
        setTabSelection(0);
        getSupportFragmentManager();
        mdrawerLayout = (DrawerLayout) findViewById(R.id.dl_drawerlayout);



    }


    private void initview() {

        navigationView = (NavigationView) findViewById(R.id.nav_view);
//        menu = (ImageView) findViewById(R.id.mian_menu);
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
//        menu.setOnClickListener(this);

    }


    public void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (index){
            case 0:
                if (messageFragment == null){
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content,messageFragment);

                }else {
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                if (newFragment == null){
                    newFragment = new NewFragment();
                    transaction.add(R.id.content,newFragment);
                }else {
                    transaction.show(newFragment);
                }
                break;
            case 2:
                if (setFragment == null){
                    setFragment = new SetFragment();
                    transaction.add(R.id.content,setFragment);
                }else {
                    transaction.show(setFragment);
                }
                break;
            case 3:
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
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
//                messageText.setTextColor();

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
//            case R.id.mian_menu:
//                if (mdrawerLayout.isDrawerOpen(navigationView)){
//                    mdrawerLayout.closeDrawer(navigationView);
//                }else {
//                    mdrawerLayout.openDrawer(navigationView);
//                }
//                break;

            default:
                break;
        }

    }

}
