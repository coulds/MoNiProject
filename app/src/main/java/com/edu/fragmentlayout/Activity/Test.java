package com.edu.fragmentlayout.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Test extends BroadcastReceiver {
    private static final String TAG = "YBS";
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("send");
        Toast.makeText(context,intent.getAction()+"\n消息内容是："+intent.getStringExtra("send"),Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: "+name);
    }
}
