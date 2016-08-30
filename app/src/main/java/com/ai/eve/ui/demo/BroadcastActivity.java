package com.ai.eve.ui.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ai.eve.ui.demo.component.MyBroadCastReceiver;

/**
 * Created by huangfu on 2016/7/14 10:38.
 */
public class BroadcastActivity extends TracerActivity{

    private MyBroadCastReceiver myBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

         //代码动态注册 （参数） qpxy4cjva7
        myBroadCastReceiver = new MyBroadCastReceiver();
        //实例化过滤器并设置要过滤的广播
        IntentFilter filter=new IntentFilter("com.demo.broadcast");
        filter.setPriority(1000);
        registerReceiver(myBroadCastReceiver,filter);
//        registerReceiver(myBroadCastReceiver,filter,"com.android.permission.SEND",null);// broadcastPermission,scheduler


        Button button= (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new  Intent();
                intent.putExtra("str","####");
                //设置intent的动作为com.demo.broadcast，可以任意定义
                intent.setAction("com.demo.broadcast");
                //发送无序广播
                sendBroadcast(intent);

                //发送有序广播
//                sendOrderedBroadcastAsUser (Intent intent,
//
//                        String receiverPermission,
//                        BroadcastReceiver resultReceiver,
//                        Handler scheduler,
//                int initialCode,
//                String initialData,
//                Bundle initialExtras)
                //第一个参数：intent
                //第二个参数：String类型的接收者权限
                //第三个参数：BroadcastReceiver 指定的接收者
                //第四个参数：Handler scheduler
                //第五个参数：int 此次广播的标记
                //第六个参数：String 初始数据
                //第七个参数：Bundle 往Intent中添加的数据
                sendOrderedBroadcast(intent, "com.android.permission.RECV",null, null, Activity.RESULT_OK, "这是初始数据",null);

            }
        });

  }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadCastReceiver);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
