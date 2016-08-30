package com.ai.eve.ui.demo.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by huangfu on 2016/7/14 10:32.
 */
//自定义广播接受者 （两种注册方式）
public class MyBroadCastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //涉及到与其他组件之间的交互 发送Notification、启动service

        //获取广播中的数据（即得到 "这是初始数据" 字符串）
        String message = getResultData();
        String str=intent.getStringExtra("str");
        Toast.makeText(context ,message+"1111 "+str ,Toast.LENGTH_SHORT).show();
        Log.e("========================",message+"===============");
        //修改数据
        setResultData("这是修改后的数据");
        abortBroadcast();
    }
}
