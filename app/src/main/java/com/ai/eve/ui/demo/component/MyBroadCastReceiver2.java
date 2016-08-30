package com.ai.eve.ui.demo.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by huangfu on 2016/7/14 10:32.
 */
//自定义广播接受者 （两种注册方式）
public class MyBroadCastReceiver2 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = getResultData();
        String str=intent.getStringExtra("str");
        Toast.makeText(context ,message+"2222"+str  ,Toast.LENGTH_SHORT).show();
        //终止广播
        abortBroadcast();
    }
}
